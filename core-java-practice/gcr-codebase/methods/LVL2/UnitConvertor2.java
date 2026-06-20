import java.util.Scanner;

public class UnitConvertor2 {
    
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }
    
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }
    
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }
    
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }
    
    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Unit Convertor - Length");
        System.out.println("1. Yards to Feet");
        System.out.println("2. Feet to Yards");
        System.out.println("3. Meters to Inches");
        System.out.println("4. Inches to Meters");
        System.out.println("5. Inches to Centimeters");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();
        
        System.out.print("Enter the value: ");
        double value = sc.nextDouble();
        
        switch (choice) {
            case 1:
                System.out.println(value + " yards = " + convertYardsToFeet(value) + " feet");
                break;
            case 2:
                System.out.println(value + " feet = " + convertFeetToYards(value) + " yards");
                break;
            case 3:
                System.out.println(value + " meters = " + convertMetersToInches(value) + " inches");
                break;
            case 4:
                System.out.println(value + " inches = " + convertInchesToMeters(value) + " meters");
                break;
            case 5:
                System.out.println(value + " inches = " + convertInchesToCentimeters(value) + " cm");
                break;
            default:
                System.out.println("Invalid choice");
        }
        
        sc.close();
    }
}
