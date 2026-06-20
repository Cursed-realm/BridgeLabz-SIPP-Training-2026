import java.util.Scanner;

public class EuclideanDistance {
    
    public static double findDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }
    
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double slope = (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - (slope * x1);
        return new double[]{slope, yIntercept};
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();
        
        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();
        
        double distance = findDistance(x1, y1, x2, y2);
        
        System.out.println("\nPoints: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")");
        System.out.println("Euclidean Distance: " + String.format("%.4f", distance));
        
        if (x1 != x2) {
            double[] lineEq = findLineEquation(x1, y1, x2, y2);
            double slope = lineEq[0];
            double yIntercept = lineEq[1];
            
            System.out.println("Line Equation: y = " + String.format("%.4f", slope) + "x + " + 
                             String.format("%.4f", yIntercept));
            System.out.println("Slope (m): " + String.format("%.4f", slope));
            System.out.println("Y-intercept (b): " + String.format("%.4f", yIntercept));
        } else {
            System.out.println("Line Equation: Vertical line x = " + x1);
        }
        
        sc.close();
    }
}
