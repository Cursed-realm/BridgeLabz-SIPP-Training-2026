import java.util.Scanner;

public class Quadratic {
    
    public static double[] findRoots(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        
        if (delta < 0) {
            return new double[]{};
        }
        
        if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        }
        
        double sqrtDelta = Math.sqrt(delta);
        double root1 = (-b + sqrtDelta) / (2 * a);
        double root2 = (-b - sqrtDelta) / (2 * a);
        return new double[]{root1, root2};
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter coefficient a: ");
        double a = sc.nextDouble();
        
        System.out.print("Enter coefficient b: ");
        double b = sc.nextDouble();
        
        System.out.print("Enter coefficient c: ");
        double c = sc.nextDouble();
        
        if (a == 0) {
            System.out.println("Coefficient 'a' cannot be zero for a quadratic equation");
        } else {
            double[] roots = findRoots(a, b, c);
            double delta = b * b - 4 * a * c;
            
            System.out.println("\nQuadratic Equation: " + a + "x² + " + b + "x + " + c + " = 0");
            System.out.println("Delta (Discriminant): " + delta);
            
            if (delta < 0) {
                System.out.println("No real roots (Delta is negative)");
            } else if (delta == 0) {
                System.out.println("One root: " + roots[0]);
            } else {
                System.out.println("Root 1: " + roots[0]);
                System.out.println("Root 2: " + roots[1]);
            }
        }
        
        sc.close();
    }
}
