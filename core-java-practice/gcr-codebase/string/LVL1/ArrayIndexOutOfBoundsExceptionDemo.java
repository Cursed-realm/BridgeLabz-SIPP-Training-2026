import java.util.Scanner;

public class ArrayIndexOutOfBoundsExceptionDemo {
    public static void generateArrayIndexOutOfBoundsException(String[] names) {
        System.out.println(names[names.length]);
    }
    
    public static void handleArrayIndexOutOfBoundsException(String[] names) {
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("Exception class: " + e.getClass().getName());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of names: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }
        
        System.out.println("===== Generating ArrayIndexOutOfBoundsException =====");
        try {
            generateArrayIndexOutOfBoundsException(names);
        } catch (Exception e) {
            System.out.println("Program crashed with: " + e.getClass().getName());
        }
        
        System.out.println("\n===== Handling ArrayIndexOutOfBoundsException =====");
        handleArrayIndexOutOfBoundsException(names);
        System.out.println("Program continues after exception handling");
        
        scanner.close();
    }
}
