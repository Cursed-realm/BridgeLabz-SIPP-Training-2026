import java.util.Scanner;

public class SubstringComparison {
    public static String createSubstring(String text, int startIndex, int endIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i < endIndex; i++) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }
    
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        System.out.print("Enter start index: ");
        int startIndex = scanner.nextInt();
        
        System.out.print("Enter end index: ");
        int endIndex = scanner.nextInt();
        
        String customSubstring = createSubstring(text, startIndex, endIndex);
        String builtInSubstring = text.substring(startIndex, endIndex);
        
        System.out.println("Custom substring: " + customSubstring);
        System.out.println("Built-in substring: " + builtInSubstring);
        
        boolean result = compareStrings(customSubstring, builtInSubstring);
        System.out.println("Substrings are equal: " + result);
        
        scanner.close();
    }
}
