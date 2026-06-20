import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonusAmounts = new double[10];
        double[] newSalaries = new double[10];
        
        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;
        
        System.out.println("Enter salary and years of service for 10 employees:");
        for (int i = 0; i < 10; i++) {
            while (true) {
                System.out.print("Employee " + (i + 1) + " salary: ");
                double salary = scanner.nextDouble();
                if (salary < 0) {
                    System.out.println("Invalid salary. Please enter a positive value.");
                    continue;
                }
                
                System.out.print("Employee " + (i + 1) + " years of service: ");
                double years = scanner.nextDouble();
                if (years < 0) {
                    System.out.println("Invalid years of service. Please enter a positive value.");
                    continue;
                }
                
                salaries[i] = salary;
                yearsOfService[i] = years;
                break;
            }
        }
        
        for (int i = 0; i < 10; i++) {
            double bonus;
            if (yearsOfService[i] > 5) {
                bonus = salaries[i] * 0.05;
            } else {
                bonus = salaries[i] * 0.02;
            }
            
            bonusAmounts[i] = bonus;
            newSalaries[i] = salaries[i] + bonus;
            totalBonus += bonus;
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }
        
        System.out.println("\n===== Employee Bonus Summary =====");
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);
        
        System.out.println("\n===== Individual Employee Details =====");
        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1) + 
                             " | Old Salary: " + salaries[i] + 
                             " | Bonus: " + bonusAmounts[i] + 
                             " | New Salary: " + newSalaries[i]);
        }
        
        scanner.close();
    }
}
