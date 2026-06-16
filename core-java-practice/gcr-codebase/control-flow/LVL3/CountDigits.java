import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        int count = 0;
        int temp = Math.abs(number);
        
        if (temp == 0) {
            count = 1;
        } else {
            while (temp != 0) {
                count++;
                temp = temp / 10;
            }
        }
        
        System.out.println("Number of digits in " + number + ": " + count);
        
        sc.close();
    }
}
