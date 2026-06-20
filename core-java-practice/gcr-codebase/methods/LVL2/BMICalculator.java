import java.util.Scanner;

public class BMICalculator {
    
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100;
            double bmi = weight / (heightM * heightM);
            data[i][2] = bmi;
        }
    }
    
    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                status[i] = "Normal";
            } else if (bmi >= 25 && bmi < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double[][] data = new double[10][3];
        
        System.out.println("Enter weight (kg) and height (cm) for 10 team members:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Member " + (i + 1) + " - Enter weight (kg): ");
            data[i][0] = sc.nextDouble();
            System.out.print("Member " + (i + 1) + " - Enter height (cm): ");
            data[i][1] = sc.nextDouble();
        }
        
        calculateBMI(data);
        String[] bmiStatus = getBMIStatus(data);
        
        System.out.println("\n=== BMI Report ===");
        System.out.println("Member\tWeight(kg)\tHeight(cm)\tBMI\t\tStatus");
        System.out.println("------\t----------\t---------\t---\t\t------");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t\t%s\n", 
                (i + 1), data[i][0], data[i][1], data[i][2], bmiStatus[i]);
        }
        
        sc.close();
    }
}
