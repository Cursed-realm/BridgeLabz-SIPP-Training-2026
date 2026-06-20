import java.util.Scanner;

public class UnitConvertor1 {
    
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }
    
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }
    
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }
    
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Unit Convertor - Distance");
        System.out.println("1. Kilometers to Miles");
        System.out.println("2. Miles to Kilometers");
        System.out.println("3. Meters to Feet");
        System.out.println("4. Feet to Meters");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();
        
        System.out.print("Enter the value: ");
        double value = sc.nextDouble();
        
        switch (choice) {
            case 1:
                System.out.println(value + " km = " + convertKmToMiles(value) + " miles");
                break;
            case 2:
                System.out.println(value + " miles = " + convertMilesToKm(value) + " km");
                break;
            case 3:
                System.out.println(value + " meters = " + convertMetersToFeet(value) + " feet");
                break;
            case 4:
                System.out.println(value + " feet = " + convertFeetToMeters(value) + " meters");
                break;
            default:
                System.out.println("Invalid choice");
        }
        
        sc.close();
    }
}
