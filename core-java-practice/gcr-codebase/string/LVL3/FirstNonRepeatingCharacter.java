import java.util.Scanner;

public class FirstNonRepeatingCharacter {
    public static char findFirstNonRepeating(String text) {
        int[] frequency = new int[256];
        
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        
        return '\0';
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        char firstNonRepeating = findFirstNonRepeating(text);
        
        System.out.println("\n===== First Non-Repeating Character =====");
        if (firstNonRepeating != '\0') {
            System.out.println("First non-repeating character: " + firstNonRepeating);
        } else {
            System.out.println("No non-repeating character found.");
        }
        
        scanner.close();
    }
}
