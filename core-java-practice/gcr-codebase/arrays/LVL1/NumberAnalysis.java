import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] numbers = new int[5];
        
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            
            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println(num + " is positive and even");
                } else {
                    System.out.println(num + " is positive and odd");
                }
            } else if (num < 0) {
                System.out.println(num + " is negative");
            } else {
                System.out.println(num + " is zero");
            }
        }
        
        int firstElement = numbers[0];
        int lastElement = numbers[numbers.length - 1];
        
        System.out.println("\nComparison of first and last elements:");
        if (firstElement == lastElement) {
            System.out.println("First element (" + firstElement + ") equals last element (" + lastElement + ")");
        } else if (firstElement > lastElement) {
            System.out.println("First element (" + firstElement + ") is greater than last element (" + lastElement + ")");
        } else {
            System.out.println("First element (" + firstElement + ") is less than last element (" + lastElement + ")");
        }
        
        scanner.close();
    }
}
