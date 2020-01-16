package leetcode;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * <p>
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 *
 * @author: bxguo
 * @time: 2020/1/2 9:52
 */
public class Solution34 {
    // O(n)
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (res[0] == -1) {
                    res[0] = i;
                    res[1] = i;
                } else {
                    res[1] = i;
                }
            }
        }
        return res;
    }

    //  O(log n)
    public int[] searchRange2(int[] nums, int target) {
        int[] res = {-1, -1};
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
                while (r < nums.length && nums[r] == target) {
                    r++;
                }
                l = mid;
                while (l >= 0 && nums[l] == target) {
                    l--;
                }
                res[1] = r - 1;
                res[0] = l + 1;
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(solution34.searchRange2(nums, 8)));

        Integer str = null;
        System.out.println(str+"");



    }
}
