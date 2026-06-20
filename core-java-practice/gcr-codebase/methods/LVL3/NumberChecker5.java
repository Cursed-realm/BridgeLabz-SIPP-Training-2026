import java.util.Scanner;

public class NumberChecker5 {
    
    public static int sumOfProperDivisors(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
    
    public static boolean isPerfectNumber(int number) {
        return number == sumOfProperDivisors(number);
    }
    
    public static boolean isAbundantNumber(int number) {
        return sumOfProperDivisors(number) > number;
    }
    
    public static boolean isDeficientNumber(int number) {
        return sumOfProperDivisors(number) < number;
    }
    
    public static long factorial(int number) {
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
    
    public static long sumOfFactorialsOfDigits(int number) {
        long sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += factorial(digit);
            number /= 10;
        }
        return sum;
    }
    
    public static boolean isStrongNumber(int number) {
        return number == sumOfFactorialsOfDigits(number);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        int sumDivisors = sumOfProperDivisors(number);
        
        System.out.println("\nNumber: " + number);
        System.out.println("Sum of Proper Divisors: " + sumDivisors);
        System.out.println("Is Perfect Number: " + isPerfectNumber(number));
        System.out.println("Is Abundant Number: " + isAbundantNumber(number));
        System.out.println("Is Deficient Number: " + isDeficientNumber(number));
        System.out.println("Is Strong Number: " + isStrongNumber(number));
        
        sc.close();
    }
}
