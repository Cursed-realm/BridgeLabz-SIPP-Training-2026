import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter weight in kg: ");
        double weight = sc.nextDouble();
        
        System.out.print("Enter height in cm: ");
        double height = sc.nextDouble();
        
        // Convert height from cm to m
        double heightInMeters = height / 100;
        
        // Calculate BMI
        double bmi = weight / (heightInMeters * heightInMeters);
        
        String status = "";
        
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            status = "Normal weight";
        } else if (bmi >= 25 && bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }
        
        System.out.println("\n--- BMI Report ---");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Height: " + height + " cm");
        System.out.println("BMI: " + String.format("%.2f", bmi));
        System.out.println("Status: " + status);
        
        sc.close();
    }
}
