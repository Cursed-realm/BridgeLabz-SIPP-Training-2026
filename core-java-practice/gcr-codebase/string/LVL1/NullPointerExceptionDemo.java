public class NullPointerExceptionDemo {
    public static void generateNullPointerException() {
        String text = null;
        System.out.println(text.length());
    }
    
    public static void handleNullPointerException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
            System.out.println("Exception class: " + e.getClass().getName());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("===== Generating NullPointerException =====");
        try {
            generateNullPointerException();
        } catch (Exception e) {
            System.out.println("Program crashed with: " + e.getClass().getName());
        }
        
        System.out.println("\n===== Handling NullPointerException =====");
        handleNullPointerException();
        System.out.println("Program continues after exception handling");
    }
}
