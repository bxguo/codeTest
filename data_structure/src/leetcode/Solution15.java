package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @author: bxguo
 * @time: 2019/9/20 9:27
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r ) {
                /*if (nums[l] == nums[l - 1]){
                    l++;
                    continue;
                }
                if (r < nums.length - 1 && nums[r] == nums[r + 1]) {
                    r--;
                    continue;
                }*/
                int num = nums[i] + nums[l] + nums[r];
                if (num == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++; // 去重
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--; // 去重
                    }
                    l++;
                    r--;
                } else if (num < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }


    /*public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i + 1; j < nums.length-1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return res;
    }*/


    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();

        int[] ints = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> x = solution15.threeSum(ints);
        System.out.println(x);
    }
}
