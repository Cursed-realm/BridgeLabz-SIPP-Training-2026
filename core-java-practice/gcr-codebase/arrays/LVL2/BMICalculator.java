import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int number = scanner.nextInt();
        
        double[] weights = new double[number];
        double[] heights = new double[number];
        double[] bmis = new double[number];
        String[] weightStatus = new String[number];
        
        for (int i = 0; i < number; i++) {
            while (true) {
                System.out.print("Person " + (i + 1) + " weight (kg): ");
                double weight = scanner.nextDouble();
                if (weight < 0) {
                    System.out.println("Invalid weight. Please enter a positive value.");
                    continue;
                }
                
                System.out.print("Person " + (i + 1) + " height (m): ");
                double height = scanner.nextDouble();
                if (height < 0) {
                    System.out.println("Invalid height. Please enter a positive value.");
                    continue;
                }
                
                weights[i] = weight;
                heights[i] = height;
                break;
            }
        }
        
        for (int i = 0; i < number; i++) {
            bmis[i] = weights[i] / (heights[i] * heights[i]);
            
            if (bmis[i] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmis[i] >= 18.5 && bmis[i] < 25) {
                weightStatus[i] = "Normal weight";
            } else if (bmis[i] >= 25 && bmis[i] < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        
        System.out.println("\n===== BMI Details =====");
        System.out.println("Height(m)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.println(heights[i] + "\t\t" + weights[i] + "\t\t" + 
                             String.format("%.2f", bmis[i]) + "\t\t" + weightStatus[i]);
        }
        
        scanner.close();
    }
}
