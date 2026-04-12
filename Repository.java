package university.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Section {
    private final String sectionId;          // CS101-A
    private final String courseId;           // FK to Course
    private String instructorId;             // FK to Instructor (nullable)
    private String term;                     // e.g:"Fall 2025"
    private int capacity;

    private final List<TimeSlot> meetingTimes = new ArrayList<>();
    // Roster is now a list of Enrollments to track students and potentially grades
    private final List<Enrollment> roster = new ArrayList<>();

    public Section(String sectionId, String courseId, String term, int capacity) {
        this.sectionId = Objects.requireNonNull(sectionId);
        this.courseId = Objects.requireNonNull(courseId);
        this.term = term;
        this.capacity = capacity;
    }

    public String getSectionId() { return sectionId; }
    public String getCourseId() { return courseId; }
    public String getInstructorId() { return instructorId; }
    public void setInstructorId(String instructorId) { this.instructorId = instructorId; }
    public String getTerm() { return term; }
    public int getCapacity() { return capacity; }
    public List<TimeSlot> getMeetingTimes() { return meetingTimes; }

    public List<Enrollment> getRoster() { return roster; }

    public boolean isFull() {
        return roster.size() >= capacity;
    }

    // Used by RegistrationService to enroll a student
    public void addEnrollment(Enrollment e) {
        roster.add(e);
    }

    // Used by RegistrationService to drop a student
    public void removeEnrollment(String studentId) {
        roster.removeIf(e -> e.getStudent().getId().equals(studentId));
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%s) Capacity: [%d/%d]", sectionId, courseId, term, roster.size(), capacity);
    }
}
