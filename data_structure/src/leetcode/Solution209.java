package leetcode;

/**
 *给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author 郭丙侠
 * @date 2023年03月31日 11:10
 */
public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int total = 0;
        int res = 0;
        int i = 0, j = 0;
        for (; j < nums.length; j++) {
            total += nums[j];
            while (total >= target) {
                res = res == 0 ? j - i + 1 : Math.min(res, j - i + 1);
                total -= nums[i++];
            }
        }
        return 0;
    }
}
