import java.util.Scanner;

public class VowelsConsonantsCount {
    public static String checkCharacterType(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char)(c + 32);
        }
        
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return "Vowel";
        } else if ((c >= 'a' && c <= 'z')) {
            return "Consonant";
        } else {
            return "Not a Letter";
        }
    }
    
    public static int[] countVowelsConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;
        
        for (int i = 0; i < text.length(); i++) {
            String type = checkCharacterType(text.charAt(i));
            
            if (type.equals("Vowel")) {
                vowelCount++;
            } else if (type.equals("Consonant")) {
                consonantCount++;
            }
        }
        
        int[] result = new int[2];
        result[0] = vowelCount;
        result[1] = consonantCount;
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        int[] counts = countVowelsConsonants(text);
        
        System.out.println("\n===== Count Analysis =====");
        System.out.println("Total Vowels: " + counts[0]);
        System.out.println("Total Consonants: " + counts[1]);
        
        scanner.close();
    }
}
