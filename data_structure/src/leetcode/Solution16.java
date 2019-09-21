package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * Created by bxguo on 2019/9/21 10:52
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        if (nums[0] > target) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r ) {
                int num = nums[i] + nums[l] + nums[r];
                System.out.println(num);
                if (num == target) {
                    return target;
                } else if (num < target) {
                    res = target - num > Math.abs(res - target) ? res : num;
                    l++;
                } else {
                    res = num - target > Math.abs(res - target) ? res : num;
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int[] ints = {6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15
                ,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6
                ,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17
                ,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9
                ,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10};
        System.out.println("-----------"+solution16.threeSumClosest(ints, -52));
    }
}
