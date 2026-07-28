import java.util.Arrays;
import java.util.Random;

public class LibrarySortComparison {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};
        Random random = new Random(123);

        for (int size : sizes) {
            int[] years = random.ints(size, 1900, 2025).toArray();
            int[] mergeInput = Arrays.copyOf(years, years.length);
            int[] quickInput = Arrays.copyOf(years, years.length);
            int[] countingInput = random.ints(size, 1, 21).toArray();

            long mergeStart = System.nanoTime();
            mergeSort(mergeInput);
            long mergeTime = System.nanoTime() - mergeStart;

            long quickStart = System.nanoTime();
            quickSort(quickInput, 0, quickInput.length - 1);
            long quickTime = System.nanoTime() - quickStart;

            long countStart = System.nanoTime();
            countingSort(countingInput, 20);
            long countTime = System.nanoTime() - countStart;

            System.out.println("Size=" + size + ": merge=" + mergeTime / 1_000_000.0 + "ms, quick=" + quickTime / 1_000_000.0 + "ms, counting=" + countTime / 1_000_000.0 + "ms");
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);
        merge(arr, temp, left, mid, right);
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[idx++] = arr[l++];
            } else {
                temp[idx++] = arr[r++];
            }
        }
        while (l <= mid) {
            temp[idx++] = arr[l++];
        }
        while (r <= right) {
            temp[idx++] = arr[r++];
        }
        System.arraycopy(temp, left, arr, left, right - left + 1);
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

    public static int[] countingSort(int[] arr, int maxValue) {
        int[] counts = new int[maxValue + 1];
        for (int value : arr) {
            counts[value]++;
        }
        int[] output = new int[arr.length];
        int idx = 0;
        for (int value = 1; value <= maxValue; value++) {
            while (counts[value]-- > 0) {
                output[idx++] = value;
            }
        }
        return output;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}