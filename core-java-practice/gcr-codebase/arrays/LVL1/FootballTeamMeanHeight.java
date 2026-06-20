import java.util.Scanner;

public class FootballTeamMeanHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double[] heights = new double[11];
        
        System.out.println("Enter the heights of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + " height (in meters): ");
            heights[i] = scanner.nextDouble();
        }
        
        double sum = 0.0;
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }
        
        double meanHeight = sum / 11;
        
        System.out.println("\nMean height of the football team: " + meanHeight + " meters");
        
        scanner.close();
    }
}
