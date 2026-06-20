import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int number = scanner.nextInt();
        
        double[] percentages = new double[number];
        String[] grades = new String[number];
        double[][] marks = new double[number][3];
        
        for (int i = 0; i < number; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                while (true) {
                    String subject = "";
                    if (j == 0) subject = "Physics";
                    else if (j == 1) subject = "Chemistry";
                    else subject = "Maths";
                    
                    System.out.print("Enter marks for " + subject + ": ");
                    double mark = scanner.nextDouble();
                    
                    if (mark < 0) {
                        System.out.println("Invalid marks. Please enter positive value.");
                        continue;
                    }
                    
                    marks[i][j] = mark;
                    break;
                }
            }
        }
        
        for (int i = 0; i < number; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
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
            System.out.println(marks[i][0] + "\t\t" + marks[i][1] + "\t\t" + 
                             marks[i][2] + "\t\t" + String.format("%.2f", percentages[i]) + 
                             "\t\t" + grades[i]);
        }
        
        scanner.close();
    }
}
