import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        int originalNumber = number;
        int sum = 0;
        
        while (originalNumber != 0) {
            // Find each digit
            int digit = originalNumber % 10;
            
            // Find the cube of the digit and add to sum
            sum += digit * digit * digit;
            
            // Remove the last digit
            originalNumber = originalNumber / 10;
        }
        
        if (number == sum) {
            System.out.println(number + " is an Armstrong Number");
        } else {
            System.out.println(number + " is not an Armstrong Number");
        }
        
        sc.close();
    }
}
