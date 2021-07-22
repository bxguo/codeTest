package base;

/**
 * @author 郭炳侠
 * @date 2021/7/19
 */
public class CoinTest {
    public static double[] coninChange(int n) {
        double[] dp = new double[n];
        dp[0] = 100;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + (dp[i - 1] * 0.1);
        }
        return dp;
    }

    public static void main(String[] args) {
        double[] doubles = coninChange(100);

        for (int i = 0; i < doubles.length; i++) {
            System.out.println(i + " :: " + doubles[i]);
        }
    }
}
