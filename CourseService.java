package university.model;

import java.util.ArrayList;
import java.util.List;

public final class Student extends Person {
    private String major;
    private int year;
    private final List<Enrollment> enrollments = new ArrayList<>();
    private final List<TranscriptEntry> transcript = new ArrayList<>();
// Constructor
    public Student(String id, String firstName, String lastName, String email, String major, int year) {
        super(id, firstName, lastName, email);
        this.major = major;
        this.year = year;
    }

    // Setters and Getters
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public List<Enrollment> getEnrollments() { return enrollments; }
    public List<TranscriptEntry> getTranscript() { return transcript; }

    public void addEnrollment(Enrollment e) { enrollments.add(e); }
    public void removeEnrollment(Enrollment e) { enrollments.remove(e); }

    public void addTranscriptEntry(TranscriptEntry entry) { transcript.add(entry); }

    @Override
    public String role() { return "STUDENT"; }
}

