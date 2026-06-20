import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        generatePermutations(s, "", s.length());
        sc.close();
    }

    public static void generatePermutations(String remaining, String current, int length) {
        if (remaining.length() == 0) {
            System.out.println(current);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            char c = remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generatePermutations(newRemaining, current + c, length);
        }
    }
}
