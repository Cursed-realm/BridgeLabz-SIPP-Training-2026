import java.util.Arrays;

public class QuickSortFlightTicketPrices {
    public static void main(String[] args) {
        int[] prices = {4500, 2200, 3800, 1800, 5200};
        quickSort(prices, 0, prices.length - 1);
        System.out.println(Arrays.toString(prices));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = arr[high];
        int lt = low;
        int gt = high;
        int i = low;
        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt++, i++);
            } else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }
        quickSort(arr, low, lt - 1);
        quickSort(arr, gt + 1, high);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}