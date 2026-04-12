package university.model;

public class TranscriptEntry {
    private final String courseCode;
    private final String term; // <-- This field is needed
    private final Grade grade;

    public TranscriptEntry(String courseCode, String term, Grade grade) {
        this.courseCode = courseCode;
        this.term = term;
        this.grade = grade;
    }

    // Required by MainMenu for displaying transcript
    public String getTerm() {
        return term;
    }

    // Required by MainMenu and RegistrationService (GPA check)
    public String getCourseCode() {
        return courseCode;
    }

    // Required by RegistrationService (GPA check)
    public Grade getGrade() {
        return grade;
    }

    // Optional: toString() for cleaner debug/display
    @Override
    public String toString() {
        return String.format("%s (%s) - Grade: %s", courseCode, term, grade.name());
    }
}
