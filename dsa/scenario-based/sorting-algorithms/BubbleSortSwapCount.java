public class BubbleSortSwapCount {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        int swaps = countSwaps(nums);
        System.out.println(swaps);
    }

    public static int countSwaps(int[] nums) {
        int n = nums.length;
        int swapCount = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapCount++;
                }
            }
        }
        return swapCount;
    }
}
