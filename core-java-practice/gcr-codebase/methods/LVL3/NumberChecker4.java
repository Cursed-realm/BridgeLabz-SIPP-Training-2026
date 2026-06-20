import java.util.Scanner;

public class NumberChecker4 {
    
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
    
    public static boolean isNeonNumber(int number) {
        int square = number * number;
        return sumOfDigits(square) == number;
    }
    
    public static int productOfDigits(int number) {
        int product = 1;
        while (number > 0) {
            product *= number % 10;
            number /= 10;
        }
        return product;
    }
    
    public static boolean isSpyNumber(int number) {
        return sumOfDigits(number) == productOfDigits(number);
    }
    
    public static boolean isAutomorphicNumber(int number) {
        int square = number * number;
        String squareStr = String.valueOf(square);
        String numberStr = String.valueOf(number);
        return squareStr.endsWith(numberStr);
    }
    
    public static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        System.out.println("\nNumber: " + number);
        System.out.println("Is Prime: " + isPrime(number));
        System.out.println("Is Neon: " + isNeonNumber(number));
        System.out.println("Is Spy: " + isSpyNumber(number));
        System.out.println("Is Automorphic: " + isAutomorphicNumber(number));
        System.out.println("Is Buzz: " + isBuzzNumber(number));
        
        sc.close();
    }
}
