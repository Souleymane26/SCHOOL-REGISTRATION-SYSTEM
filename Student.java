package university.model;

public class Enrollment {
    private final Student student;
    private final Section section;
    private Grade grade; //The field to store the grade

    public Enrollment(Student student, Section section) {
        this.student = student;
        this.section = section;
        this.grade = null; // Initially no grade
    }

    // Getter and Setter for the grade
    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) { //Used by RegistrationService.assignGrade()
        this.grade = grade;
    }

    // Existing getters
    public Student getStudent() {
        return student;
    }

    public Section getSection() {
        return section;
    }


}
