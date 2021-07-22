package labuladong;

/**
 * 输入一个目标金额n，返回凑出目标金额n的最少硬币数量
 *
 * @author 郭炳侠
 * @date 2021/7/12
 */
public class CoinChange {

    public int coninChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < coins.length; i++) {
            int subRes = coninChange(coins, amount - coins[i]);
            if (subRes == -1) {
                continue;
            }
            res = Math.min(res, subRes + 1);
        }
        return res;
    }

    /**
     * 备忘录
     */
    public int coninChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
