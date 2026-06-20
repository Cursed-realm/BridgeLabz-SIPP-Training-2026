import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int number = scanner.nextInt();
        
        double[][] personData = new double[number][3];
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
                
                personData[i][0] = height;
                personData[i][1] = weight;
                break;
            }
        }
        
        for (int i = 0; i < number; i++) {
            double bmi = personData[i][1] / (personData[i][0] * personData[i][0]);
            personData[i][2] = bmi;
            
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                weightStatus[i] = "Normal weight";
            } else if (bmi >= 25 && bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        
        System.out.println("\n===== BMI Details =====");
        System.out.println("Height(m)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.println(personData[i][0] + "\t\t" + personData[i][1] + "\t\t" + 
                             String.format("%.2f", personData[i][2]) + "\t\t" + weightStatus[i]);
        }
        
        scanner.close();
    }
}
