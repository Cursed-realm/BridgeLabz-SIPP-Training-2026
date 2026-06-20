import java.util.Scanner;

public class TrimSpaces {
    public static int[] findTrimIndexes(String text) {
        int length = text.length();
        int startIndex = 0;
        int endIndex = length - 1;
        
        while (startIndex < length && text.charAt(startIndex) == ' ') {
            startIndex++;
        }
        
        while (endIndex >= 0 && text.charAt(endIndex) == ' ') {
            endIndex--;
        }
        
        int[] result = new int[2];
        result[0] = startIndex;
        result[1] = endIndex + 1;
        return result;
    }
    
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
        
        System.out.print("Enter text (with spaces): ");
        String text = scanner.nextLine();
        
        int[] indexes = findTrimIndexes(text);
        String customTrimmed = createSubstring(text, indexes[0], indexes[1]);
        String builtInTrimmed = text.trim();
        
        System.out.println("Original text: '" + text + "'");
        System.out.println("Custom trim: '" + customTrimmed + "'");
        System.out.println("Built-in trim: '" + builtInTrimmed + "'");
        
        boolean result = compareStrings(customTrimmed, builtInTrimmed);
        System.out.println("Results match: " + result);
        
        scanner.close();
    }
}
