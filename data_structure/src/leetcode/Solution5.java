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
                if (dp[i][j]){
                    if (i - j + 1 > max) {
                        max = i - j + 1;
                        res = s.substring(j, i+1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        String babad = solution5.longestPalindrome("babad");
        System.out.println(babad);
    }
}
