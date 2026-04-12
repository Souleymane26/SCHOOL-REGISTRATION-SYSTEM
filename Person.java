package university.model;

import java.util.ArrayList;
import java.util.List;

public final class Course {
    private final String code; // e.g., CS101
    private String title;
    private int credits;
    private final List<String> prerequisites = new ArrayList<>(); // course codes

    public Course(String code, String title, int credits) {
        if (credits <= 0) throw new IllegalArgumentException("credits must be > 0");
        this.code = code;
        this.title = title;
        this.credits = credits;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public List<String> getPrerequisites() { return prerequisites; }

    public void addPrerequisite(String courseCode) {
        if (!prerequisites.contains(courseCode)) prerequisites.add(courseCode);
    }
}
