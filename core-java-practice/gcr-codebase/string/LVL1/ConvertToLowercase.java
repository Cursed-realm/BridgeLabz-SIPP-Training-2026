import java.util.Scanner;

public class ConvertToLowercase {
    public static String convertToLowercase(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sb.append((char)(c + 32));
            } else {
                sb.append(c);
            }
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
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        String customLowercase = convertToLowercase(text);
        String builtInLowercase = text.toLowerCase();
        
        System.out.println("Custom lowercase: " + customLowercase);
        System.out.println("Built-in lowercase: " + builtInLowercase);
        
        boolean result = compareStrings(customLowercase, builtInLowercase);
        System.out.println("Results are equal: " + result);
        
        scanner.close();
    }
}
