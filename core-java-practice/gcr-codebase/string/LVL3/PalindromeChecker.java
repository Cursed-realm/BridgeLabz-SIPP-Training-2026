import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        String clean = text.replaceAll(" ", "").toLowerCase();
        int start = 0;
        int end = clean.length() - 1;
        
        while (start < end) {
            if (clean.charAt(start) != clean.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        String clean = text.replaceAll(" ", "").toLowerCase();
        if (start >= end) {
            return true;
        }
        
        if (clean.charAt(start) != clean.charAt(end)) {
            return false;
        }
        
        return isPalindromeRecursive(text, start + 1, end - 1);
    }
    
    public static String reverseString(String text) {
        StringBuilder reversed = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed.append(text.charAt(i));
        }
        return reversed.toString();
    }
    
    public static boolean isPalindromeCharArray(String text) {
        String clean = text.replaceAll(" ", "").toLowerCase();
        String reversed = reverseString(clean);
        return clean.equals(reversed);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        boolean result1 = isPalindromeIterative(text);
        boolean result2 = isPalindromeRecursive(text, 0, text.replaceAll(" ", "").toLowerCase().length() - 1);
        boolean result3 = isPalindromeCharArray(text);
        
        System.out.println("\n===== Palindrome Check =====");
        System.out.println("Iterative method: " + result1);
        System.out.println("Recursive method: " + result2);
        System.out.println("Character array method: " + result3);
        System.out.println("Is Palindrome: " + result1);
        
        scanner.close();
    }
}
