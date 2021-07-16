package labuladong;

/**
 * 输入一个目标金额n，返回凑出目标金额n的最少硬币数量
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



}
