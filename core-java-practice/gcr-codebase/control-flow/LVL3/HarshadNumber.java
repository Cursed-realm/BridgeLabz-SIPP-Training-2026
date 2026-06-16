import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        int temp = number;
        int sum = 0;
        
        // Find sum of digits
        while (temp != 0) {
            sum += temp % 10;
            temp = temp / 10;
        }
        
        // Check if number is divisible by sum of its digits
        if (number % sum == 0) {
            System.out.println(number + " is a Harshad Number");
        } else {
            System.out.println(number + " is not a Harshad Number");
        }
        
        sc.close();
    }
}
