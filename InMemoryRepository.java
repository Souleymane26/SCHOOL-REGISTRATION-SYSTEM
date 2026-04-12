package university.model;

public abstract class Person { // Person abstract calss
    private final String id;
    private String firstName;
    private String lastName;
    private String email;

    // My constructor
    protected Person(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Setters and Getters
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getFullName() { return firstName + " " + lastName; }

    public abstract String role();


    //toString Method
    @Override
    public String toString() {
        return String.format("[%s] %s (%s)", getId(), getFullName(), role());
    }
}
