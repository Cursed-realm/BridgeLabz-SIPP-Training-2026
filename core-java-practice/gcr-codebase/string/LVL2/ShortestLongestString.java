import java.util.Scanner;

public class ShortestLongestString {
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
    
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findStringLength(words[i]));
        }
        
        return result;
    }
    
    public static int[] findShortestAndLongest(String[][] wordsWithLengths) {
        int[] result = new int[2];
        int shortestIndex = 0;
        int longestIndex = 0;
        
        int shortestLength = Integer.parseInt(wordsWithLengths[0][1]);
        int longestLength = Integer.parseInt(wordsWithLengths[0][1]);
        
        for (int i = 1; i < wordsWithLengths.length; i++) {
            int currentLength = Integer.parseInt(wordsWithLengths[i][1]);
            
            if (currentLength < shortestLength) {
                shortestLength = currentLength;
                shortestIndex = i;
            }
            
            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestIndex = i;
            }
        }
        
        result[0] = shortestIndex;
        result[1] = longestIndex;
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        String[] words = splitIntoWords(text);
        String[][] wordsWithLengths = getWordsWithLengths(words);
        int[] indexes = findShortestAndLongest(wordsWithLengths);
        
        int shortestIndex = indexes[0];
        int longestIndex = indexes[1];
        
        System.out.println("\n===== Analysis =====");
        System.out.println("Shortest word: " + wordsWithLengths[shortestIndex][0] + 
                         " (Length: " + wordsWithLengths[shortestIndex][1] + ")");
        System.out.println("Longest word: " + wordsWithLengths[longestIndex][0] + 
                         " (Length: " + wordsWithLengths[longestIndex][1] + ")");
        
        scanner.close();
    }
}
