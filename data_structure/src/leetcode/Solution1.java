package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * Created by bxguo on 2019/9/14 18:38
 */
public class Solution1 {

    //耗时 29 ms
    public int[] twoSum3(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{};
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(target - nums[i])) {
                return new int[]{list.indexOf(target - nums[i]), i};
            }
            list.add(nums[i]);
        }
        return new int[]{};
    }

    //TODO 最优 耗时 8 ms (因为要获取下标所以下标只能存map.val)
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    /*
       O(n^2)  55 ms
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{};
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int temp = nums[i] + nums[j];
                if(temp == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
