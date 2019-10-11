package base;

/**
 * 走方格问题
 * @author: bxguo
 * @time: 2019/10/11 15:29
 */
public class MinimumPath {
    public int getMin(int[][] map, int n, int m) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][0] += map[j][0];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                dp[0][i] += map[0][j];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = min(dp[i - 1][j] + map[i][j], dp[i][j - 1] + map[i][j]);
            }
        }
        return dp[n - 1][m - 1];
    }

    private int min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }
}
