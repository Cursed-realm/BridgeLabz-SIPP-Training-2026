import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        
        if (number <= 0) {
            System.out.println("Error: Please enter a positive integer");
            scanner.close();
            return;
        }
        
        String[] fizzBuzzArray = new String[number + 1];
        
        for (int i = 0; i <= number; i++) {
            if (i == 0) {
                fizzBuzzArray[i] = "0";
            } else if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzzArray[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                fizzBuzzArray[i] = "Fizz";
            } else if (i % 5 == 0) {
                fizzBuzzArray[i] = "Buzz";
            } else {
                fizzBuzzArray[i] = String.valueOf(i);
            }
        }
        
        System.out.println("\nFizzBuzz Results:");
        for (int i = 0; i <= number; i++) {
            System.out.println("Position " + i + " = " + fizzBuzzArray[i]);
        }
        
        scanner.close();
    }
}
