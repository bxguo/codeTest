package hw;

/**
 * 有一辆小船，能够承载的最高重量为c，当船承载的重量超过c时，船会沉没。
 * 现在有n个物品，物品i的重量为w(i),价值为v(i)，
 * 应该如何选择装船的物品，保证船不沉，使得装上船的物品总价值最大?
 *
 * @author: bxguo
 * @time: 2020/2/19 15:36
 */
public class Chuan {
    //totalVal  = v(0)*个数+ ... +*v(n-1)*个数
    //w(0)*个数+...+w(0)*个数<=c

    class item{
        int w;
        int v;
    }


    public static void main(String[] args) {
        int n = 6, c = 10;                   //物品个数6，船承载的重量
        int[] value = {0, 1, 2, 3, 4, 6};     //假设 n = 6，各个物品的价值
        int[] weight = {0, 1, 2, 3, 4, 6};    //假设 n = 6， 各个物品的重量
        System.out.println(fun(weight, value, c, n));
    }

    public static int fun(int[] weight, int[] value, int c, int n) {
        int[][] dp = new int[n + 1][c + 1];
        for (int i = 0; i <= c; i++) {
            dp[0][i] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[j][0] = 0;
        }
        for (int i = 1; i <= n; i++) { //物品个数
            for (int j = 1; j <= c; j++) {  //船承载
                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];//当前物品装不下
                } else { //装得下
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[n][c];
    }
}
