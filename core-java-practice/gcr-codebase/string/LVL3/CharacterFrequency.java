import java.util.Scanner;

public class CharacterFrequency {
    public static String[][] findCharacterFrequency(String text) {
        int[] frequency = new int[256];
        
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        
        String[][] result = new String[text.length()][2];
        int count = 0;
        
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                result[count][0] = String.valueOf((char)i);
                result[count][1] = String.valueOf(frequency[i]);
                count++;
            }
        }
        
        String[][] finalResult = new String[count][2];
        for (int i = 0; i < count; i++) {
            finalResult[i][0] = result[i][0];
            finalResult[i][1] = result[i][1];
        }
        
        return finalResult;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        String[][] charFrequency = findCharacterFrequency(text);
        
        System.out.println("\n===== Character Frequency =====");
        System.out.println("Character\tFrequency");
        for (int i = 0; i < charFrequency.length; i++) {
            System.out.println(charFrequency[i][0] + "\t\t" + charFrequency[i][1]);
        }
        
        scanner.close();
    }
}
