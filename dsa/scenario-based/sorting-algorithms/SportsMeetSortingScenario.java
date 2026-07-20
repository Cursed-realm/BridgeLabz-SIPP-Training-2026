import java.util.Arrays;
import java.util.Random;

public class SportsMeetSortingScenario {
    public static void main(String[] args) {
        int[] athleteScores = generateAthleteScores(50);

        int[] bubbleSortedScores = athleteScores.clone();
        int bubbleSwapCount = bubbleSort(bubbleSortedScores);
        boolean isAlreadySorted = bubbleSwapCount == 0;

        int[] insertionSortedScores = athleteScores.clone();
        insertionSort(insertionSortedScores);

        int[] topThreeMedalists = getTopThreeScores(bubbleSortedScores);

        System.out.println("Bubble Sort Swap Count: " + bubbleSwapCount);
        System.out.println("Already Sorted (Best Case): " + isAlreadySorted);
        System.out.println("Top 3 Medalists: " + Arrays.toString(topThreeMedalists));

        int[] traceArray = {64, 25, 12, 22, 11};
        tracePassByPassBubbleSort(traceArray);
    }

    public static int[] generateAthleteScores(int count) {
        Random random = new Random();
        int[] scores = new int[count];
        for (int i = 0; i < count; i++) {
            scores[i] = random.nextInt(100) + 1;
        }
        return scores;
    }

    public static int bubbleSort(int[] scores) {
        int n = scores.length;
        int swapCount = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (scores[j] > scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                    swapCount++;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return swapCount;
    }

    public static void insertionSort(int[] scores) {
        int n = scores.length;
        for (int i = 1; i < n; i++) {
            int key = scores[i];
            int j = i - 1;
            while (j >= 0 && scores[j] > key) {
                scores[j + 1] = scores[j];
                j--;
            }
            scores[j + 1] = key;
        }
    }

    public static int[] getTopThreeScores(int[] sortedScores) {
        int n = sortedScores.length;
        return new int[] { sortedScores[n - 1], sortedScores[n - 2], sortedScores[n - 3] };
    }

    public static void tracePassByPassBubbleSort(int[] array) {
        int n = array.length;
        System.out.println("Initial Array: " + Arrays.toString(array));
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println("After Pass " + (i + 1) + ": " + Arrays.toString(array));
        }
    }
}
