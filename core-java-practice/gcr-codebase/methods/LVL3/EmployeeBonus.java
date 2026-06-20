import java.util.Scanner;

public class EmployeeBonus {
    
    public static double[][] generateSalaryAndService() {
        double[][] data = new double[10][2];
        for (int i = 0; i < 10; i++) {
            data[i][0] = 10000 + (int)(Math.random() * 90000);
            data[i][1] = 1 + (int)(Math.random() * 30);
        }
        return data;
    }
    
    public static double[][] calculateBonusAndNewSalary(double[][] data) {
        double[][] result = new double[10][3];
        
        for (int i = 0; i < 10; i++) {
            double oldSalary = data[i][0];
            double yearsOfService = data[i][1];
            double bonusPercentage;
            
            if (yearsOfService > 5) {
                bonusPercentage = 0.05;
            } else {
                bonusPercentage = 0.02;
            }
            
            double bonus = oldSalary * bonusPercentage;
            double newSalary = oldSalary + bonus;
            
            result[i][0] = oldSalary;
            result[i][1] = newSalary;
            result[i][2] = bonus;
        }
        
        return result;
    }
    
    public static void displaySalaryReport(double[][] salaryData, double[][] resultData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;
        
        System.out.println("\n=== Employee Salary Report ===");
        System.out.println("Employee\tYears\tOld Salary\tBonus\t\tNew Salary");
        System.out.println("--------\t-----\t----------\t------\t\t----------");
        
        for (int i = 0; i < 10; i++) {
            double oldSalary = resultData[i][0];
            double newSalary = resultData[i][1];
            double bonus = resultData[i][2];
            int years = (int)salaryData[i][1];
            
            System.out.printf("%d\t\t%d\t%.2f\t\t%.2f\t\t%.2f\n", 
                            (i + 1), years, oldSalary, bonus, newSalary);
            
            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;
        }
        
        System.out.println("--------\t-----\t----------\t------\t\t----------");
        System.out.printf("Total\t\t\t%.2f\t\t%.2f\t\t%.2f\n", 
                        totalOldSalary, totalBonus, totalNewSalary);
    }
    
    public static void main(String[] args) {
        double[][] salaryData = generateSalaryAndService();
        double[][] resultData = calculateBonusAndNewSalary(salaryData);
        displaySalaryReport(salaryData, resultData);
    }
}
