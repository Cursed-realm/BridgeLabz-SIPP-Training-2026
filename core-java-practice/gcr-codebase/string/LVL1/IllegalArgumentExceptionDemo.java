import java.util.Scanner;

public class IllegalArgumentExceptionDemo {
    public static void generateIllegalArgumentException(String text) {
        System.out.println(text.substring(10, 5));
    }
    
    public static void handleIllegalArgumentException(String text) {
        try {
            System.out.println(text.substring(10, 5));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
            System.out.println("Exception class: " + e.getClass().getName());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        System.out.println("===== Generating IllegalArgumentException =====");
        try {
            generateIllegalArgumentException(text);
        } catch (Exception e) {
            System.out.println("Program crashed with: " + e.getClass().getName());
        }
        
        System.out.println("\n===== Handling IllegalArgumentException =====");
        handleIllegalArgumentException(text);
        System.out.println("Program continues after exception handling");
        
        scanner.close();
    }
}
