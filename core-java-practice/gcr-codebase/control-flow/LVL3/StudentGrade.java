import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Physics marks: ");
        double physics = sc.nextDouble();
        
        System.out.print("Enter Chemistry marks: ");
        double chemistry = sc.nextDouble();
        
        System.out.print("Enter Maths marks: ");
        double maths = sc.nextDouble();
        
        double averageMark = (physics + chemistry + maths) / 3;
        double percentage = averageMark;
        
        String grade = "";
        String remark = "";
        
        if (percentage >= 90) {
            grade = "A";
            remark = "Excellent";
        } else if (percentage >= 80) {
            grade = "B";
            remark = "Very Good";
        } else if (percentage >= 70) {
            grade = "C";
            remark = "Good";
        } else if (percentage >= 60) {
            grade = "D";
            remark = "Average";
        } else if (percentage >= 50) {
            grade = "E";
            remark = "Satisfactory";
        } else {
            grade = "F";
            remark = "Fail";
        }
        
        System.out.println("\n--- Result ---");
        System.out.println("Physics: " + physics);
        System.out.println("Chemistry: " + chemistry);
        System.out.println("Maths: " + maths);
        System.out.println("Average Mark: " + averageMark);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remark);
        
        sc.close();
    }
}
