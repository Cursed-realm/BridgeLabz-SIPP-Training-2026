import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int[] multiplicationResult = new int[10];
        
        for (int i = 0; i < 10; i++) {
            multiplicationResult[i] = number * (i + 1);
        }
        
        System.out.println("\nMultiplication Table of " + number + ":");
        for (int i = 0; i < multiplicationResult.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + multiplicationResult[i]);
        }
        
        scanner.close();
    }
}
