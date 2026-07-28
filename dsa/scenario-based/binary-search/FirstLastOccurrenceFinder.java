public class FirstLastOccurrenceFinder {
    public static int[] findFirstAndLast(int[] arr, int target) {
        int first = findBoundary(arr, target, true);
        int last = findBoundary(arr, target, false);
        return new int[]{first, last};
    }

    private static int findBoundary(int[] arr, int target, boolean findFirst) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                if (findFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4};
        int[] result = findFirstAndLast(arr, 2);
        System.out.println("First: " + result[0] + ", Last: " + result[1]);
    }
}