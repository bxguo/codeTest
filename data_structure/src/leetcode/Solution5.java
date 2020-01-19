package leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *      i=4     |
 *      b a b a d
 *      j=2 |
 * Created by bxguo on 2019/9/15 16:41
 */
public class Solution5 {

    /*
     * 两个向中心缩进式 的比较
     * 动态规划dp 主要运用的是回溯的思想，即这一步它是回文数的话那上一层必然也是回文数
     * 通过二维数组记录每一个是回文数的位置，可以逐个追溯到一位或两位从而判断当前最大位置
     * 是不是回文数
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String res = "";
        int max = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1]);
                if (dp[j][i]){
                    if (i - j + 1 > max) {
                        max = i - j + 1;
                        res = s.substring(j, i+1);
                    }
                }
            }
        }
        return res;
    }

    /*
     * 中心扩散法(要区分回文数长度是奇数偶数两种情况)
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            res = fun(s, res, i, i);       //奇数回文数
            res = fun(s, res, i, i + 1);//偶数回文数
        }
        return res;
    }

    private String fun(String s, String res, int m, int n) {
        while (m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)) {
            m--;
            n++;
        }
        if (res.length() < n - m - 1) {
            res = s.substring(m + 1, n);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        String babad = solution5.longestPalindrome2("babad");
        System.out.println(babad);
    }
}
