import java.util.Scanner;

public class NaturalNumberSumWhileLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        if (number > 0) {
            // Calculate sum using formula
            int sumFormula = number * (number + 1) / 2;
            
            // Calculate sum using while loop
            int sumLoop = 0;
            int counter = 1;
            
            while (counter <= number) {
                sumLoop += counter;
                counter++;
            }
            
            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Sum using while loop: " + sumLoop);
            System.out.println("Are both results equal? " + (sumFormula == sumLoop));
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }
        
        sc.close();
    }
}
