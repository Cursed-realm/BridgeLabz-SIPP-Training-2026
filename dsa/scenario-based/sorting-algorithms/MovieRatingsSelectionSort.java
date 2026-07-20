public class MovieRatingsSelectionSort {
    public static void main(String[] args) {
        int[] ratings = {8, 5, 9, 7, 6, 10};
        selectionSort(ratings);
        for (int rating : ratings) {
            System.out.print(rating + " ");
        }
    }

    public static void selectionSort(int[] ratings) {
        int n = ratings.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (ratings[j] < ratings[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = ratings[minIndex];
            ratings[minIndex] = ratings[i];
            ratings[i] = temp;
        }
    }
}
