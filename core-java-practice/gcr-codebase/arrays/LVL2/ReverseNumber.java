import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();
        long tempNumber = number;
        
        int digitCount = 0;
        while (tempNumber != 0) {
            digitCount++;
            tempNumber = tempNumber / 10;
        }
        
        int[] digits = new int[digitCount];
        int index = 0;
        tempNumber = number;
        
        while (tempNumber != 0) {
            int digit = (int)(tempNumber % 10);
            digits[index] = digit;
            index++;
            tempNumber = tempNumber / 10;
        }
        
        int[] reversedDigits = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            reversedDigits[i] = digits[digitCount - 1 - i];
        }
        
        System.out.print("Reversed number: ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(reversedDigits[i]);
        }
        System.out.println();
        
        scanner.close();
    }
}
