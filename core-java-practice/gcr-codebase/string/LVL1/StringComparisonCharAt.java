import java.util.Scanner;

public class StringComparisonCharAt {
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
        
        System.out.print("Enter first string: ");
        String str1 = scanner.next();
        
        System.out.print("Enter second string: ");
        String str2 = scanner.next();
        
        boolean customResult = compareStrings(str1, str2);
        boolean builtInResult = str1.equals(str2);
        
        System.out.println("Custom charAt() comparison: " + customResult);
        System.out.println("Built-in equals() method: " + builtInResult);
        System.out.println("Results match: " + (customResult == builtInResult));
        
        scanner.close();
    }
}
