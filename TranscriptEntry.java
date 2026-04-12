package university.model;

import java.util.ArrayList;
import java.util.List;

public final class Instructor extends Person {
    private String department;
    // Section IDs assigned to this instructor (not used in UI but good for data integrity)
    private final List<String> assignedSectionIds = new ArrayList<>();

    public Instructor(String id, String firstName, String lastName, String email, String department) {
        super(id, firstName, lastName, email);
        this.department = department;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public List<String> getAssignedSectionIds() { return assignedSectionIds; }

    @Override
    public String role() { return "INSTRUCTOR"; }
}