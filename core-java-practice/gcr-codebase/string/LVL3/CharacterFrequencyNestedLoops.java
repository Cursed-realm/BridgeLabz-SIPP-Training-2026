import java.util.Scanner;

public class CharacterFrequencyNestedLoops {
    public static String[] findCharacterFrequency(String text) {
        char[] chars = text.toCharArray();
        int[] frequency = new int[chars.length];
        
        for (int i = 0; i < chars.length; i++) {
            frequency[i] = 1;
            
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    frequency[i]++;
                    chars[j] = '0';
                }
            }
        }
        
        String[] result = new String[chars.length];
        int count = 0;
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[count] = chars[i] + ": " + frequency[i];
                count++;
            }
        }
        
        String[] finalResult = new String[count];
        for (int i = 0; i < count; i++) {
            finalResult[i] = result[i];
        }
        
        return finalResult;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        String[] charFrequency = findCharacterFrequency(text);
        
        System.out.println("\n===== Character Frequency (Nested Loops) =====");
        System.out.println("Character: Frequency");
        for (int i = 0; i < charFrequency.length; i++) {
            System.out.println(charFrequency[i]);
        }
        
        scanner.close();
    }
}
