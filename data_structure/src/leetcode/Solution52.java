package leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author: bxguo
 * @time: 2019/10/12 10:12
 */
public class Solution52 {
    //dp 动态规划 time O(n)  space dO(n)
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
            res = Math.max(dp[i], res);
        }
        return res;
    }

    //简化的动态规划，因为此题只需要知道最大值即可并不需要知道每一步决策的最大值
    public int maxSubArray2(int[] nums) {
        int ans = nums[0];
        int sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], sum);
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
