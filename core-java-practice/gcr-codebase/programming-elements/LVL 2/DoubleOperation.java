import java.util.Scanner;

public class DoubleOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter value of a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Enter value of b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Enter value of c: ");
        double c = scanner.nextDouble();
        
        // Operator Precedence: *, / have higher precedence than +, -
        double result1 = a + b * c;  // multiplication first, then addition
        double result2 = a * b + c;  // multiplication first, then addition
        double result3 = c + a / b;  // division first, then addition
        double result4 = a % b + c;  // modulus first, then addition
        
        System.out.println("The results of Double Operations are " + result1 + ", " + result2 + ", " + result3 + ", and " + result4);
        
        scanner.close();
    }
}
