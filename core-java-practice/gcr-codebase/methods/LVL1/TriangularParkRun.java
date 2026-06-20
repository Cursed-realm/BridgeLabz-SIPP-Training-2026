import java.util.Scanner;

public class TriangularParkRun {
    
    public static double calculatePerimeter(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }
    
    public static double calculateRounds(double perimeter) {
        double totalDistance = 5000;
        return totalDistance / perimeter;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter side 1 (in meters): ");
        double side1 = sc.nextDouble();
        
        System.out.print("Enter side 2 (in meters): ");
        double side2 = sc.nextDouble();
        
        System.out.print("Enter side 3 (in meters): ");
        double side3 = sc.nextDouble();
        
        double perimeter = calculatePerimeter(side1, side2, side3);
        double rounds = calculateRounds(perimeter);
        
        System.out.println("Perimeter of triangle: " + perimeter + " meters");
        System.out.println("Number of rounds to complete 5 km: " + rounds);
        
        sc.close();
    }
}
