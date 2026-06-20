import java.util.Scanner;

public class StudentScorecard {
    
    public static int[][] generateRandomScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = 10 + (int)(Math.random() * 90);
            scores[i][1] = 10 + (int)(Math.random() * 90);
            scores[i][2] = 10 + (int)(Math.random() * 90);
        }
        return scores;
    }
    
    public static double[][] calculateTotalAveragePercentage(int[][] scores) {
        double[][] results = new double[scores.length][4];
        
        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3;
            double percentage = (total / 300) * 100;
            
            results[i][0] = scores[i][0];
            results[i][1] = scores[i][1];
            results[i][2] = scores[i][2];
            results[i][3] = total;
            
            results[i][0] = scores[i][0];
            results[i][1] = average;
            results[i][2] = percentage;
            results[i][3] = total;
        }
        
        return results;
    }
    
    public static void displayScorecard(int[][] scores) {
        System.out.println("\n=== Student Scorecard ===");
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage");
        System.out.println("-------\t-------\t---------\t----\t-----\t-------\t----------");
        
        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = Math.round((total / 3) * 100.0) / 100.0;
            double percentage = Math.round(((total / 300) * 100) * 100.0) / 100.0;
            
            System.out.printf("%d\t%d\t%d\t\t%d\t%.0f\t%.2f\t%.2f\n",
                            (i + 1), scores[i][0], scores[i][1], scores[i][2], 
                            (int)total, average, percentage);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        
        int[][] scores = generateRandomScores(numStudents);
        displayScorecard(scores);
        
        sc.close();
    }
}
