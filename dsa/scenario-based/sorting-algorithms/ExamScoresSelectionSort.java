public class ExamScoresSelectionSort {
    public static void main(String[] args) {
        int[] scores = {72, 45, 89, 63, 90, 51};
        selectionSort(scores);
        for (int score : scores) {
            System.out.print(score + " ");
        }
    }

    public static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }
}
