import java.util.Scanner;

public class CharArrayComparison {
    public static char[] getCharArray(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }
    
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        char[] customArray = getCharArray(text);
        char[] builtInArray = text.toCharArray();
        
        System.out.println("Custom char array: ");
        for (char c : customArray) {
            System.out.print(c);
        }
        System.out.println();
        
        System.out.println("Built-in toCharArray: ");
        for (char c : builtInArray) {
            System.out.print(c);
        }
        System.out.println();
        
        boolean result = compareCharArrays(customArray, builtInArray);
        System.out.println("Arrays are equal: " + result);
        
        scanner.close();
    }
}
