// Section 3 – Problem 1: University Management System
// Demonstrates: public, protected, private access modifiers + inheritance

class Student {
    public    int    rollNumber;   // accessible everywhere
    protected String name;         // accessible in same package + subclasses
    private   double CGPA;         // accessible only within Student class

    Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name       = name;
        this.CGPA       = CGPA;
    }

    // Public getter – only way to read private CGPA from outside
    public double getCGPA() {
        return CGPA;
    }

    // Public setter – only way to modify private CGPA from outside
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0)
            this.CGPA = CGPA;
        else
            System.out.println("Invalid CGPA. Must be between 0.0 and 10.0");
    }

    public void display() {
        System.out.println("Roll No: " + rollNumber
                         + " | Name: " + name
                         + " | CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student {
    String researchTopic;

    PostgraduateStudent(int rollNumber, String name, double CGPA, String researchTopic) {
        super(rollNumber, name, CGPA);
        this.researchTopic = researchTopic;
    }

    @Override
    public void display() {
        // rollNumber → public    : directly accessible ✓
        // name       → protected : accessible in subclass ✓
        // CGPA       → private   : NOT directly accessible, use getCGPA() ✓
        System.out.println("PG Student"
                         + " | Roll: " + rollNumber
                         + " | Name: " + name
                         + " | CGPA: " + getCGPA()
                         + " | Research: " + researchTopic);
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        Student s = new Student(101, "Kavya", 8.5);
        System.out.println("-- Student --");
        s.display();

        s.setCGPA(9.2);
        System.out.println("After CGPA update: " + s.getCGPA());

        s.setCGPA(11.0);   // invalid – prints error message

        System.out.println("\n-- Postgraduate Student --");
        PostgraduateStudent pg = new PostgraduateStudent(
                201, "Vikram", 8.9, "Machine Learning");
        pg.display();
    }
}
