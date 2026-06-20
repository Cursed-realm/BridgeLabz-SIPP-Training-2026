import java.util.Scanner;

public class SumNaturalNumbers {
    
    public static long sumRecursive(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumRecursive(n - 1);
    }
    
    public static long sumFormula(int n) {
        return (long) n * (n + 1) / 2;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a natural number (greater than 0)");
        } else {
            long recursiveSum = sumRecursive(n);
            long formulaSum = sumFormula(n);
            
            System.out.println("Sum using Recursion: " + recursiveSum);
            System.out.println("Sum using Formula n*(n+1)/2: " + formulaSum);
            
            if (recursiveSum == formulaSum) {
                System.out.println("Both results are equal and correct!");
            } else {
                System.out.println("Results do not match");
            }
        }
        
        sc.close();
    }
}
