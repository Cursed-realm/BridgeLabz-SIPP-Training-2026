public class RotationPointFinder {
    public static int findRotationPoint(int[] arr) {
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
        return left;
    }

    public static void main(String[] args) {
        int[] rotated = {13, 18, 25, 2, 8, 10};
        System.out.println("Rotation point index: " + findRotationPoint(rotated));
    }
}