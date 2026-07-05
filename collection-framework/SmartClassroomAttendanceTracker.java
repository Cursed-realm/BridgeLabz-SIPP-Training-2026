import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartClassroomAttendanceTracker {
    private Map<String, ArrayList<String>> subjectAttendance;

    public SmartClassroomAttendanceTracker() {
        subjectAttendance = new HashMap<String, ArrayList<String>>();
    }

    public boolean markAttendance(String subject, String studentName) {
        if (subject == null || subject.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject must not be empty");
        }
        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name must not be empty");
        }
        ArrayList<String> students = subjectAttendance.get(subject);
        if (students == null) {
            students = new ArrayList<String>();
            subjectAttendance.put(subject, students);
        }
        if (students.contains(studentName)) {
            return false;
        }
        students.add(studentName);
        return true;
    }

    public void displayAttendanceForSubject(String subject) {
        ArrayList<String> students = subjectAttendance.get(subject);
        if (students == null) {
            System.out.println("No attendance records for " + subject);
            return;
        }
        System.out.println("Attendance for " + subject + ":");
        for (String student : students) {
            System.out.println(student);
        }
        System.out.println("Total present: " + students.size());
    }

    public void displayAllAttendance() {
        for (Map.Entry<String, ArrayList<String>> entry : subjectAttendance.entrySet()) {
            System.out.println("Subject: " + entry.getKey());
            for (String student : entry.getValue()) {
                System.out.println(student);
            }
            System.out.println("Total present: " + entry.getValue().size());
        }
    }

    public static void main(String[] args) {
        SmartClassroomAttendanceTracker attendanceTracker = new SmartClassroomAttendanceTracker();

        attendanceTracker.markAttendance("Java Programming", "Aditya");
        attendanceTracker.markAttendance("Java Programming", "Zara");
        attendanceTracker.markAttendance("Data Structures", "Manav");

        boolean duplicate = attendanceTracker.markAttendance("Java Programming", "Aditya");
        System.out.println("Duplicate attendance prevented: " + !duplicate);

        attendanceTracker.markAttendance("Data Structures", "Aditya");

        attendanceTracker.displayAllAttendance();
    }
}
