package leetcode;

/**
 * @author: bxguo
 * @time: 2019/7/20 11:27
 */
public class Solution31 {

    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        int[] nums = {1, 23, 31, 12};
        int k = 10;
        System.out.println(solution31.partitionArray(nums, k));
    }

    /**
     * @param nums: The integer array you should partition
     * @param k:    An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {

            while (left <= right && nums[left] < k) {
                left++;
            }

            while (left <= right && nums[right] >= k) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }
        return left;
    }
}
