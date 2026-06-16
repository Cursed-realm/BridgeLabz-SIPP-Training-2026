import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter base of triangle (in cm): ");
        double base = scanner.nextDouble();
        
        System.out.print("Enter height of triangle (in cm): ");
        double height = scanner.nextDouble();
        
        double areaInSquareCm = 0.5 * base * height;
        double areaInSquareInches = areaInSquareCm / (2.54 * 2.54);
        
        System.out.println("The Area of the triangle in sq in is " + areaInSquareInches + " and sq cm is " + areaInSquareCm);
        
        scanner.close();
    }
}
