import java.util.Scanner;

public class BMICalculatorTeam {
    public static String getStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Normal";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
    
    public static String[][] calculateBMI(double[][] data) {
        String[][] result = new String[data.length][4];
        
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);
            String status = getStatus(bmi);
            
            result[i][0] = String.valueOf(heightCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = status;
        }
        
        return result;
    }
    
    public static void displayTable(String[][] data) {
        System.out.println("\n===== BMI Status of Team Members =====");
        System.out.println("Height(cm)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1] + "\t\t" + data[i][2] + "\t\t" + data[i][3]);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double[][] personData = new double[10][2];
        
        System.out.println("Enter weight (kg) and height (cm) for 10 team members:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Person " + (i + 1) + " weight: ");
            personData[i][0] = scanner.nextDouble();
            System.out.print("Person " + (i + 1) + " height (cm): ");
            personData[i][1] = scanner.nextDouble();
        }
        
        String[][] bmiData = calculateBMI(personData);
        displayTable(bmiData);
        
        scanner.close();
    }
}
