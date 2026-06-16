import java.util.Scanner;

public class NaturalNumberSumForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        if (number > 0) {
            // Calculate sum using formula
            int sumFormula = number * (number + 1) / 2;
            
            // Calculate sum using for loop
            int sumLoop = 0;
            
            for (int i = 1; i <= number; i++) {
                sumLoop += i;
            }
            
            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Sum using for loop: " + sumLoop);
            System.out.println("Are both results equal? " + (sumFormula == sumLoop));
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }
        
        sc.close();
    }
}
