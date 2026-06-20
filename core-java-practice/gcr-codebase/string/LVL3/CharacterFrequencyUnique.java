import java.util.Scanner;

public class CharacterFrequencyUnique {
    public static char[] findUniqueCharacters(String text) {
        char[] temp = new char[text.length()];
        int uniqueCount = 0;
        
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean isUnique = true;
            
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == c) {
                    isUnique = false;
                    break;
                }
            }
            
            if (isUnique) {
                temp[uniqueCount] = c;
                uniqueCount++;
            }
        }
        
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }
        
        return result;
    }
    
    public static String[][] findCharacterFrequency(String text) {
        int[] frequency = new int[256];
        
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        
        char[] uniqueChars = findUniqueCharacters(text);
        String[][] result = new String[uniqueChars.length][2];
        
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(frequency[uniqueChars[i]]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        String[][] charFrequency = findCharacterFrequency(text);
        
        System.out.println("\n===== Character Frequency (Using Unique) =====");
        System.out.println("Character\tFrequency");
        for (int i = 0; i < charFrequency.length; i++) {
            System.out.println(charFrequency[i][0] + "\t\t" + charFrequency[i][1]);
        }
        
        scanner.close();
    }
}
