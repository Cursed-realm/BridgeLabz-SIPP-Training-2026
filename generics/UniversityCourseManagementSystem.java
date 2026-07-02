import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String evaluationMethod;

    public CourseType(String evaluationMethod) {
        if (evaluationMethod == null || evaluationMethod.trim().isEmpty()) {
            throw new IllegalArgumentException("Evaluation method must not be empty");
        }
        this.evaluationMethod = evaluationMethod;
    }

    public String getEvaluationMethod() {
        return evaluationMethod;
    }
}

class ExamCourse extends CourseType {
    private int totalMarks;

    public ExamCourse(int totalMarks) {
        super("Exam-Based");
        if (totalMarks <= 0) {
            throw new IllegalArgumentException("Total marks must be positive");
        }
        this.totalMarks = totalMarks;
    }

    public int getTotalMarks() {
        return totalMarks;
    }
}

class AssignmentCourse extends CourseType {
    private int totalAssignments;

    public AssignmentCourse(int totalAssignments) {
        super("Assignment-Based");
        if (totalAssignments <= 0) {
            throw new IllegalArgumentException("Total assignments must be positive");
        }
        this.totalAssignments = totalAssignments;
    }

    public int getTotalAssignments() {
        return totalAssignments;
    }
}

class ResearchCourse extends CourseType {
    private String thesisTopic;

    public ResearchCourse(String thesisTopic) {
        super("Research-Based");
        if (thesisTopic == null || thesisTopic.trim().isEmpty()) {
            throw new IllegalArgumentException("Thesis topic must not be empty");
        }
        this.thesisTopic = thesisTopic;
    }

    public String getThesisTopic() {
        return thesisTopic;
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name must not be empty");
        }
        if (courseType == null) {
            throw new IllegalArgumentException("Course type must not be null");
        }
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }

    public String toString() {
        return courseName + " (" + courseType.getEvaluationMethod() + ")";
    }
}

public class UniversityCourseManagementSystem {

    public static void displayCourseTypes(List<? extends CourseType> courseTypes) {
        if (courseTypes == null) {
            throw new IllegalArgumentException("Course types list must not be null");
        }
        for (CourseType type : courseTypes) {
            System.out.println(type.getEvaluationMethod());
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> dataStructures = new Course<ExamCourse>("Data Structures", new ExamCourse(100));
        Course<AssignmentCourse> webDevelopment = new Course<AssignmentCourse>("Web Development", new AssignmentCourse(5));
        Course<ResearchCourse> machineLearning = new Course<ResearchCourse>("Machine Learning", new ResearchCourse("Neural Network Optimization"));

        List<Course<?>> allCourses = new ArrayList<Course<?>>();
        allCourses.add(dataStructures);
        allCourses.add(webDevelopment);
        allCourses.add(machineLearning);

        System.out.println("All Offered Courses:");
        for (Course<?> course : allCourses) {
            System.out.println(course);
        }

        List<CourseType> types = new ArrayList<CourseType>();
        types.add(dataStructures.getCourseType());
        types.add(webDevelopment.getCourseType());
        types.add(machineLearning.getCourseType());

        System.out.println("Evaluation Methods:");
        displayCourseTypes(types);
    }
}
