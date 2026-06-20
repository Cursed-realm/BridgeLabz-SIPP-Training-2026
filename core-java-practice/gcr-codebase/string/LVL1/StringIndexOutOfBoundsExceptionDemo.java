import java.util.Scanner;

public class StringIndexOutOfBoundsExceptionDemo {
    public static void generateStringIndexOutOfBoundsException(String text) {
        System.out.println(text.charAt(text.length()));
    }
    
    public static void handleStringIndexOutOfBoundsException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("Exception class: " + e.getClass().getName());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        System.out.println("===== Generating StringIndexOutOfBoundsException =====");
        try {
            generateStringIndexOutOfBoundsException(text);
        } catch (Exception e) {
            System.out.println("Program crashed with: " + e.getClass().getName());
        }
        
        System.out.println("\n===== Handling StringIndexOutOfBoundsException =====");
        handleStringIndexOutOfBoundsException(text);
        System.out.println("Program continues after exception handling");
        
        scanner.close();
    }
}
