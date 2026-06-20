import java.util.Scanner;

public class SumOfNaturalNumbers {
    
    public static long calculateSum(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        
        long sum = calculateSum(n);
        
        System.out.println("Sum of first " + n + " natural numbers: " + sum);
        
        sc.close();
    }
}
