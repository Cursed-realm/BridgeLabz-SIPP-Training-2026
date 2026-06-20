import java.util.Scanner;

public class UnitConvertor3 {
    
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }
    
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }
    
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }
    
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Unit Convertor - Temperature, Weight, Volume");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("3. Pounds to Kilograms");
        System.out.println("4. Kilograms to Pounds");
        System.out.println("5. Gallons to Liters");
        System.out.println("6. Liters to Gallons");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();
        
        System.out.print("Enter the value: ");
        double value = sc.nextDouble();
        
        switch (choice) {
            case 1:
                System.out.println(value + " F = " + String.format("%.2f", convertFahrenheitToCelsius(value)) + " C");
                break;
            case 2:
                System.out.println(value + " C = " + String.format("%.2f", convertCelsiusToFahrenheit(value)) + " F");
                break;
            case 3:
                System.out.println(value + " lbs = " + String.format("%.2f", convertPoundsToKilograms(value)) + " kg");
                break;
            case 4:
                System.out.println(value + " kg = " + String.format("%.2f", convertKilogramsToPounds(value)) + " lbs");
                break;
            case 5:
                System.out.println(value + " gallons = " + String.format("%.2f", convertGallonsToLiters(value)) + " liters");
                break;
            case 6:
                System.out.println(value + " liters = " + String.format("%.2f", convertLitersToGallons(value)) + " gallons");
                break;
            default:
                System.out.println("Invalid choice");
        }
        
        sc.close();
    }
}
