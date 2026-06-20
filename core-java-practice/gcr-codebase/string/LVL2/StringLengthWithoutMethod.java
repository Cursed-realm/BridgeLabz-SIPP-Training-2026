import java.util.Scanner;

public class StringLengthWithoutMethod {
    public static int findStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        int customLength = findStringLength(text);
        int builtInLength = text.length();
        
        System.out.println("Custom length method: " + customLength);
        System.out.println("Built-in length() method: " + builtInLength);
        System.out.println("Results match: " + (customLength == builtInLength));
        
        scanner.close();
    }
}
