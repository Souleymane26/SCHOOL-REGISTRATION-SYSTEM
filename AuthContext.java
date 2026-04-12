package university.repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors; // Note: This import is unused in the final code.

/**
 * A concrete implementation of the Repository interface that stores data
 * entirely in memory using a ConcurrentHashMap.
 * This class is generic, supporting any entity type T and any ID type ID.
 * It is suitable for testing or small, non-persistent applications.
 *
 * @param <T> The type of the entity (e.g., Student, Course, Section).
 * @param <ID> The type of the entity's unique identifier (e.g., String).
 */
public class InMemoryRepository<T, ID> implements Repository<T, ID> {

    // The central data structure. ConcurrentHashMap is used for thread safety,
    // although for this single-threaded app, HashMap would also suffice.
    private final Map<ID, T> store = new ConcurrentHashMap<>();

    // A function used to extract the unique ID from an entity object (T).
    // Necessary because the repository needs the ID to use as the map key.
    private final java.util.function.Function<T, ID> idExtractor;

    /**
     * Constructor. Requires a function to know how to get the ID from an entity.
     * @param idExtractor A function that maps an entity (T) to its ID (ID).
     */
    public InMemoryRepository(java.util.function.Function<T, ID> idExtractor) {
        this.idExtractor = idExtractor;
    }

    /**
     * Retrieves an entity by its ID.
     * @param id The unique identifier of the entity.
     * @return An Optional containing the entity if found, or an empty Optional otherwise.
     */
    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(store.get(id));
    }

    /**
     * Retrieves all entities stored in the repository.
     * @return A List containing all entities. A new ArrayList is returned to prevent
     * external modification of the internal map's values.
     */
    @Override
    public List<T> findAll() {
        return new ArrayList<>(store.values());
    }

    /**
     * Saves a new entity or updates an existing one if the ID already exists.
     * @param entity The entity to save.
     * @return The saved entity.
     */
    @Override
    public T save(T entity) {
        // Use the injected function to get the ID from the entity
        ID id = idExtractor.apply(entity);
        store.put(id, entity); // Puts or overwrites the entity based on its ID
        return entity;
    }

    /**
     * Deletes an entity from the repository by its ID.
     * @param id The unique identifier of the entity to delete.
     */
    @Override
    public void deleteById(ID id) {
        store.remove(id);
    }
}
