import java.util.Scanner;

public class SplitTextIntoWords {
    public static int findStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    
    public static String[] splitIntoWords(String text) {
        int length = findStringLength(text);
        int wordCount = 0;
        int[] spaceIndexes = new int[length];
        
        spaceIndexes[0] = -1;
        wordCount = 1;
        
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[wordCount] = i;
                wordCount++;
            }
        }
        spaceIndexes[wordCount] = length;
        
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            int startIndex = spaceIndexes[i] + 1;
            int endIndex = spaceIndexes[i + 1];
            StringBuilder word = new StringBuilder();
            
            for (int j = startIndex; j < endIndex; j++) {
                word.append(text.charAt(j));
            }
            words[i] = word.toString();
        }
        
        return words;
    }
    
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        String[] customWords = splitIntoWords(text);
        String[] builtInWords = text.split(" ");
        
        System.out.println("\nCustom split:");
        for (String word : customWords) {
            System.out.print(word + " ");
        }
        System.out.println();
        
        System.out.println("Built-in split:");
        for (String word : builtInWords) {
            System.out.print(word + " ");
        }
        System.out.println();
        
        boolean result = compareStringArrays(customWords, builtInWords);
        System.out.println("Results match: " + result);
        
        scanner.close();
    }
}
