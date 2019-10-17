package base;

import java.util.HashMap;
import java.util.Map;

/**
 * 共n个台阶每次走一步或两步共有多少种走法
 *
 * @author: bxguo
 * @time: 2019/10/14 17:33
 */
public class ClambingWay {

    //递归
    int clam(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return clam(n - 2) + clam(n - 1);
    }

    //备忘录
    int clam2(int n, Map<Integer, Integer> map) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.get(n) != null) {
            return map.get(n);
        } else {
            return clam(n - 2) + clam(n - 1);
        }
    }

    //动态规划
    int clam3(int n) {
        int[] dp = new int[10];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        ClambingWay clambingWay = new ClambingWay();
        System.out.println(clambingWay.clam3(3));
    }
}
