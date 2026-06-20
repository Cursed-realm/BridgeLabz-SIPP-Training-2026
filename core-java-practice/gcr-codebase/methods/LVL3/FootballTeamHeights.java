import java.util.Scanner;

public class FootballTeamHeights {
    
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }
    
    public static double findMean(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }
    
    public static int findShortest(int[] heights) {
        int shortest = heights[0];
        for (int height : heights) {
            if (height < shortest) {
                shortest = height;
            }
        }
        return shortest;
    }
    
    public static int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }
        return tallest;
    }
    
    public static void main(String[] args) {
        int[] heights = new int[11];
        
        System.out.println("Generating random heights for 11 football players:");
        for (int i = 0; i < 11; i++) {
            heights[i] = 150 + (int)(Math.random() * 101);
            System.out.println("Player " + (i + 1) + ": " + heights[i] + " cm");
        }
        
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);
        double mean = findMean(heights);
        
        System.out.println("\n=== Football Team Height Analysis ===");
        System.out.println("Shortest height: " + shortest + " cm");
        System.out.println("Tallest height: " + tallest + " cm");
        System.out.println("Mean height: " + String.format("%.2f", mean) + " cm");
    }
}
