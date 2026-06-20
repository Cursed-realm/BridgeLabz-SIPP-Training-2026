import java.util.Scanner;

public class CollinearPoints {
    
    public static boolean areCollinearBySlope(double x1, double y1, double x2, double y2, 
                                              double x3, double y3) {
        double slope1 = (y2 - y1) / (x2 - x1);
        double slope2 = (y3 - y2) / (x3 - x2);
        return slope1 == slope2;
    }
    
    public static boolean areCollinearByArea(double x1, double y1, double x2, double y2, 
                                             double x3, double y3) {
        double area = Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
        return area == 0;
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
        
        System.out.print("Enter x3: ");
        double x3 = sc.nextDouble();
        System.out.print("Enter y3: ");
        double y3 = sc.nextDouble();
        
        System.out.println("\nPoints: A(" + x1 + ", " + y1 + "), B(" + x2 + ", " + y2 + 
                          "), C(" + x3 + ", " + y3 + ")");
        
        boolean collinearSlope = areCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean collinearArea = areCollinearByArea(x1, y1, x2, y2, x3, y3);
        
        System.out.println("Collinear by Slope Method: " + collinearSlope);
        System.out.println("Collinear by Area Method: " + collinearArea);
        
        sc.close();
    }
}
