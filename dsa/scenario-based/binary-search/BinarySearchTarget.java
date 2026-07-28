import java.util.Arrays;

public class BinarySearchTarget {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int searchRotated(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int[] firstAndLastOccurrence(int[] arr, int target) {
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

    public static int findMinimumInRotated(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }

    public static void main(String[] args) {
        int[] sortedStars = {1, 3, 5, 7, 9, 11, 13};
        System.out.println("Binary search target 7: " + binarySearch(sortedStars, 7));

        int[] rotatedCatalog = {9, 11, 13, 1, 3, 5, 7};
        System.out.println("Search rotated target 3: " + searchRotated(rotatedCatalog, 3));

        int[] repeated = {2, 4, 4, 4, 6, 8};
        System.out.println("First and last occurrence of 4: " + Arrays.toString(firstAndLastOccurrence(repeated, 4)));

        int[] rotatedMin = {15, 18, 2, 5, 6, 8, 12};
        System.out.println("Minimum in rotated array: " + findMinimumInRotated(rotatedMin));
    }
}