package lintcode;

/**
 * 计算数字 k 在 0 到 n 中的出现的次数，k 可能是 0~9 的一个值。
 * @author: bxguo
 * @time: 2019/7/23 16:30
 */
public class Solution3 {
    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */

    public int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        for (int i = 0; i <= n; i++) {
            String s = i + "";
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == (char) (k + 48)) {
                    count++;
                }

            }
        }
        return count;
    }
    public int digitCounts2(int k, int n) {
        // write your code here
        int count = 0;
        for (int i = 0; i <= n; i++) {
            int temp = i;
            while (temp > 0) {
                if ((temp % 10) == k) {
                    count++;
                }
                temp = temp / 10;
            }
        }
        return count;
    }
}
