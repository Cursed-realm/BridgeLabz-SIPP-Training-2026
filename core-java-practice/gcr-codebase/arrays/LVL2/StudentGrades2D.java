import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int number = scanner.nextInt();
        
        double[][] studentData = new double[number][3];
        double[] percentages = new double[number];
        String[] grades = new String[number];
        
        for (int i = 0; i < number; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            String[] subjects = {"Physics", "Chemistry", "Maths"};
            
            for (int j = 0; j < 3; j++) {
                while (true) {
                    System.out.print("Enter marks for " + subjects[j] + ": ");
                    double mark = scanner.nextDouble();
                    
                    if (mark < 0) {
                        System.out.println("Invalid marks. Please enter positive value.");
                        continue;
                    }
                    
                    studentData[i][j] = mark;
                    break;
                }
            }
        }
        
        for (int i = 0; i < number; i++) {
            double total = studentData[i][0] + studentData[i][1] + studentData[i][2];
            percentages[i] = (total / 300) * 100;
            
            if (percentages[i] >= 90) {
                grades[i] = "A";
            } else if (percentages[i] >= 80) {
                grades[i] = "B";
            } else if (percentages[i] >= 70) {
                grades[i] = "C";
            } else if (percentages[i] >= 60) {
                grades[i] = "D";
            } else if (percentages[i] >= 50) {
                grades[i] = "E";
            } else {
                grades[i] = "F";
            }
        }
        
        System.out.println("\n===== Student Results =====");
        System.out.println("Physics\t\tChemistry\tMaths\t\tPercentage\tGrade");
        for (int i = 0; i < number; i++) {
            System.out.println(studentData[i][0] + "\t\t" + studentData[i][1] + "\t\t" + 
                             studentData[i][2] + "\t\t" + String.format("%.2f", percentages[i]) + 
                             "\t\t" + grades[i]);
        }
        
        scanner.close();
    }
}
