package leetcode;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @author: bxguo
 * @time: 2019/10/10 9:35
 */
public class Solution31 {
public void nextPermutation(int[] nums) {
    for (int i = nums.length - 1; i > 0; i--) {
        if (nums[i] > nums[i - 1]) {
            for (int j = nums.length - 1; j > i - 1; j--) {
                if (nums[j] > nums[i - 1]) {
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[j];
                    nums[j] = temp;
                    swap(nums, i);
                    return;
                }
            }
        }
    }
    swap(nums, 0);
}

private void swap(int[] nums, int start) {
    int swapLen = nums.length - start;
    for (int i = 0; i < swapLen / 2; i++) {
        int temp = nums[nums.length - i - 1];
        nums[nums.length -i - 1] = nums[start];
        nums[start++] = temp;
    }
}

public static void main(String[] args) {
    Solution31 solution31 = new Solution31();
    int[] nums = {5,4,7,5,3,2};
    solution31.nextPermutation(nums);
    System.out.println(nums);
}
}
