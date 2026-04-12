package university.model;

public final class Admin extends Person {
    public Admin(String id, String firstName, String lastName, String email) {
        super(id, firstName, lastName, email);
    }

    @Override
    public String role() { return "ADMIN"; }
}
