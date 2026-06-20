import java.util.Scanner;

public class TrigonometricFunctions {
    
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
        return new double[]{sine, cosine, tangent};
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter angle (in degrees): ");
        double angle = sc.nextDouble();
        
        double[] result = calculateTrigonometricFunctions(angle);
        
        System.out.println("Angle: " + angle + " degrees");
        System.out.println("Sine: " + String.format("%.4f", result[0]));
        System.out.println("Cosine: " + String.format("%.4f", result[1]));
        System.out.println("Tangent: " + String.format("%.4f", result[2]));
        
        sc.close();
    }
}
