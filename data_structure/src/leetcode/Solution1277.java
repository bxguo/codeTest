package leetcode;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Created by 郭炳侠 on 2021/4/17.
 */
public class Solution1277 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        System.out.println(Solution1277.countSquares(matrix));
    }

    public static int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // dp[i][j] 代表以 (i, j) 为右下角的正方形个数
        int[][] dp = new int[m][n];
        // 统计所有的正方形个数，作为返回值
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // 如果 matrix[i][j] == 0，那么不需要考虑，它不可能成为一个正方形的右下角，所以直接置0
                if (matrix[i][j] == 0) dp[i][j] = 0;
                    // 如果碰到了左边或者上边边界，而且里面的值还是 1，那么以 (i, j) 为右下角的正方形个数只能为 1
                else if (i == 0 || j == 0) dp[i][j] = 1;
                    // 否则的话，就根据状态方程，更新个数
                else dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                // 记得统计数据
                ans += dp[i][j];
            }
        }
        return ans;
    }

    //public static int maximalSquare2(int[][] matrix) {
    //    int maxSide = 0;
    //    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    //        return maxSide;
    //    }
    //    int rows = matrix.length, columns = matrix[0].length;
    //    int[][] dp = new int[rows][columns];
    //    for (int i = 0; i < rows; i++) {
    //        for (int j = 0; j < columns; j++) {
    //            if (matrix[i][j] == 1) {
    //                if (i == 0 || j == 0) {
    //                    dp[i][j] = 1;
    //                } else {
    //                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
    //                }
    //                maxSide = Math.max(maxSide, dp[i][j]);
    //            }
    //        }
    //    }
    //    return maxSide * maxSide;
    //}
}
