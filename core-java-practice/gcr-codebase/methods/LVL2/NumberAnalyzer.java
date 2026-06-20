import java.util.Scanner;

public class NumberAnalyzer {
    
    public static boolean isPositive(int number) {
        return number > 0;
    }
    
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] numbers = new int[5];
        
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }
        
        System.out.println("\nNumber Analysis:");
        for (int i = 0; i < numbers.length; i++) {
            if (isPositive(numbers[i])) {
                System.out.print(numbers[i] + " is Positive");
                if (isEven(numbers[i])) {
                    System.out.println(" and Even");
                } else {
                    System.out.println(" and Odd");
                }
            } else if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is Negative");
            } else {
                System.out.println(numbers[i] + " is Zero");
            }
        }
        
        int comparisonResult = compare(numbers[0], numbers[4]);
        System.out.println("\nComparison of first and last element:");
        if (comparisonResult == 1) {
            System.out.println("First element (" + numbers[0] + ") is greater than last element (" + numbers[4] + ")");
        } else if (comparisonResult == 0) {
            System.out.println("First element (" + numbers[0] + ") is equal to last element (" + numbers[4] + ")");
        } else {
            System.out.println("First element (" + numbers[0] + ") is less than last element (" + numbers[4] + ")");
        }
        
        sc.close();
    }
}
