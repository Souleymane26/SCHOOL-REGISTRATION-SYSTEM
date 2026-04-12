package university.repository;

import java.util.List;
import java.util.Optional;

/**
 * Defines the contract (interface) for a generic Repository component.
 * This interface establishes the standard CRUD (Create, Read, Update, Delete)
 * operations required for all persistent entities in the application, such as
 * Student, Course, and Section.
 *
 * The use of generics ensures that the data access logic is reusable and
 * type-safe for any entity type.
 *
 * @param <T> The type of the entity (e.g., Person, Course, Section).
 * @param <ID> The type of the entity's unique identifier (e.g., String).
 */
public interface Repository<T, ID> {

    /**
     * Retrieves an entity by its unique identifier.
     * Uses Optional to clearly indicate that the entity may not exist,
     * preventing NullPointerExceptions.
     * @param id The unique identifier.
     * @return An Optional containing the entity if found, or an empty Optional.
     */
    Optional<T> findById(ID id);

    /**
     * Retrieves all entities of type T stored in the repository.
     * @return A List of all entities.
     */
    List<T> findAll();

    /**
     * Saves a given entity. If the entity's ID already exists, it updates the
     * existing record; otherwise, it creates a new record.
     * @param entity The entity to be saved or updated.
     * @return The saved entity.
     */
    T save(T entity);

    /**
     * Deletes the entity with the given ID from the repository.
     * @param id The unique identifier of the entity to delete.
     */
    void deleteById(ID id);
}
