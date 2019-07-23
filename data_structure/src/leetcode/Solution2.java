package leetcode;

/**
 * 设计一个算法，计算出n阶乘中尾部零的个数
 * @author: bxguo
 * @time: 2019/7/23 15:53
 */
public class Solution2 {
    /*
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.

        if (n == 0) {
            return 1;
        }

        long sum = 0;
        while (n != 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;


        /*if (n == 0) {
            return 1;
        }
        long temp = 1L;
        for (long i = 0; i < n; i++) {
            long l = i + 1;
            temp = temp * l;
        }
        long count = 0;
        String s = temp + "";
        for (int i = s.length(); i > 0; i--) {
            if ('0' == (s.charAt(i - 1))) {
                count++;
            }else {
                break;
            }
        }
        return count;*/
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        long l = solution2.trailingZeros(0);
        System.out.println(l);
    }
}
