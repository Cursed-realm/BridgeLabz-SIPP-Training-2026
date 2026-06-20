import java.util.Scanner;

public class ConvertToUppercase {
    public static String convertToUppercase(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append((char)(c - 32));
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
        
        String customUppercase = convertToUppercase(text);
        String builtInUppercase = text.toUpperCase();
        
        System.out.println("Custom uppercase: " + customUppercase);
        System.out.println("Built-in uppercase: " + builtInUppercase);
        
        boolean result = compareStrings(customUppercase, builtInUppercase);
        System.out.println("Results are equal: " + result);
        
        scanner.close();
    }
}
