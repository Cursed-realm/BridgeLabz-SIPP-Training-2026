import java.util.Scanner;

public class VowelsConsonantsDisplay {
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
    
    public static String[][] getCharacterTypes(String text) {
        String[][] result = new String[text.length()][2];
        
        for (int i = 0; i < text.length(); i++) {
            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = checkCharacterType(text.charAt(i));
        }
        
        return result;
    }
    
    public static void displayTable(String[][] data) {
        System.out.println("\n===== Character Type Analysis =====");
        System.out.println("Character\tType");
        for (int i = 0; i < data.length; i++) {
            if (!data[i][1].equals("Not a Letter")) {
                System.out.println(data[i][0] + "\t\t" + data[i][1]);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        String[][] characterTypes = getCharacterTypes(text);
        displayTable(characterTypes);
        
        scanner.close();
    }
}
