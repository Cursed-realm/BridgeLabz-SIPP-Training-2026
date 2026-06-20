import java.util.Scanner;

public class NumberFormatExceptionDemo {
    public static void generateNumberFormatException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Number: " + number);
    }
    
    public static void handleNumberFormatException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
            System.out.println("Exception class: " + e.getClass().getName());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a text (should be numeric): ");
        String text = scanner.next();
        
        System.out.println("===== Generating NumberFormatException =====");
        try {
            generateNumberFormatException(text);
        } catch (Exception e) {
            System.out.println("Program crashed with: " + e.getClass().getName());
        }
        
        System.out.println("\n===== Handling NumberFormatException =====");
        handleNumberFormatException(text);
        System.out.println("Program continues after exception handling");
        
        scanner.close();
    }
}
