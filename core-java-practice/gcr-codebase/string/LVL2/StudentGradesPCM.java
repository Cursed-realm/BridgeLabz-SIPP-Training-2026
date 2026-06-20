import java.util.Scanner;

public class StudentGradesPCM {
    public static int[][] generateRandomScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = (int)(Math.random() * 100);
            scores[i][1] = (int)(Math.random() * 100);
            scores[i][2] = (int)(Math.random() * 100);
        }
        
        return scores;
    }
    
    public static double[][] calculateScoreDetails(int[][] scores) {
        double[][] details = new double[scores.length][5];
        
        for (int i = 0; i < scores.length; i++) {
            double physics = scores[i][0];
            double chemistry = scores[i][1];
            double maths = scores[i][2];
            
            details[i][0] = physics;
            details[i][1] = chemistry;
            details[i][2] = maths;
            details[i][3] = physics + chemistry + maths;
            details[i][4] = Math.round((details[i][3] / 3.0) * 100.0) / 100.0;
        }
        
        return details;
    }
    
    public static String getGrade(double percentage) {
        if (percentage >= 90) return "A";
        else if (percentage >= 80) return "B";
        else if (percentage >= 70) return "C";
        else if (percentage >= 60) return "D";
        else if (percentage >= 50) return "E";
        else return "F";
    }
    
    public static String[][] calculateGrades(double[][] details) {
        String[][] grades = new String[details.length][1];
        
        for (int i = 0; i < details.length; i++) {
            grades[i][0] = getGrade(details[i][4]);
        }
        
        return grades;
    }
    
    public static void displayScorecard(int[][] scores, double[][] details, String[][] grades) {
        System.out.println("\n===== Student Scorecard =====");
        System.out.println("Physics\tChemistry\tMaths\t\tTotal\t\tAverage\t\tGrade");
        
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i][0] + "\t" + scores[i][1] + "\t\t" + scores[i][2]);
            System.out.print("\t\t" + (int)details[i][3] + "\t\t" + 
                           String.format("%.2f", details[i][4]) + "\t\t" + grades[i][0]);
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        
        int[][] scores = generateRandomScores(numStudents);
        double[][] details = calculateScoreDetails(scores);
        String[][] grades = calculateGrades(details);
        
        displayScorecard(scores, details, grades);
        
        scanner.close();
    }
}
