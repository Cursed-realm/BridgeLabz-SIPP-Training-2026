public class InsertionSortArray {
    public static void main(String[] args) {
        int[] nums = {12, 11, 13, 5, 6};
        int[] sorted = insertionSort(nums);
        for (int num : sorted) {
            System.out.print(num + " ");
        }
    }

    public static int[] insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        return nums;
    }
}
