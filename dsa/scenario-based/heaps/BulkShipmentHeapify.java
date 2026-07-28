public class BulkShipmentHeapify {
    public static void main(String[] args) {
        int[] priorities = {8, 1, 6, 3, 10, 2, 7, 4, 9, 5};
        buildMinHeap(priorities);
        System.out.println("Min-heap built in place:");
        printArray(priorities);
    }

    public static void buildMinHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, n);
        }
    }

    private static void siftDown(int[] arr, int i, int size) {
        int smallest = i;
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < size && arr[left] < arr[smallest]) {
                smallest = left;
            }
            if (right < size && arr[right] < arr[smallest]) {
                smallest = right;
            }
            if (smallest == i) {
                break;
            }
            swap(arr, i, smallest);
            i = smallest;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
