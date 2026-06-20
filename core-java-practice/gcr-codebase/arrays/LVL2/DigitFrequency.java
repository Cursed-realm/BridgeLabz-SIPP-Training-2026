import java.util.Scanner;

public class DigitFrequency {
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
        
        int[] frequency = new int[10];
        
        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }
        
        System.out.println("\n===== Digit Frequency =====");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i]);
            }
        }
        
        scanner.close();
    }
}
