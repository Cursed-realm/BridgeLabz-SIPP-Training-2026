import java.util.Scanner;

public class AnagramChecker {
    public static boolean areAnagrams(String text1, String text2) {
        String str1 = text1.replaceAll(" ", "").toLowerCase();
        String str2 = text2.replaceAll(" ", "").toLowerCase();
        
        if (str1.length() != str2.length()) {
            return false;
        }
        
        int[] frequency1 = new int[256];
        int[] frequency2 = new int[256];
        
        for (int i = 0; i < str1.length(); i++) {
            frequency1[str1.charAt(i)]++;
        }
        
        for (int i = 0; i < str2.length(); i++) {
            frequency2[str2.charAt(i)]++;
        }
        
        for (int i = 0; i < 256; i++) {
            if (frequency1[i] != frequency2[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first text: ");
        String text1 = scanner.nextLine();
        
        System.out.print("Enter second text: ");
        String text2 = scanner.nextLine();
        
        boolean result = areAnagrams(text1, text2);
        
        System.out.println("\n===== Anagram Check =====");
        System.out.println("Text 1: " + text1);
        System.out.println("Text 2: " + text2);
        System.out.println("Are anagrams: " + result);
        
        scanner.close();
    }
}
