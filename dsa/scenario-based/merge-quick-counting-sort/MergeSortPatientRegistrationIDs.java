import java.util.Arrays;

public class MergeSortPatientRegistrationIDs {
    public static void main(String[] args) {
        int[] ids = {105, 101, 108, 102, 104};
        mergeSort(ids);
        System.out.println(Arrays.toString(ids));
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
}