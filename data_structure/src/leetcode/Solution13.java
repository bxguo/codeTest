package leetcode;

/**
 * KMP 算法
 * 对于一个给定的 source 字符串和一个 target 字符串，
 * 你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
 * @author: bxguo
 * @time: 2019/8/2 17:35
 */
public class Solution13 {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public int strStr(String source, String target) {
        if (source == null || target == null || target.length() < 1 || source.length() < target.length()) {
            return -1;
        }
        int n = source.length();
        int m = target.length();
        int i = 0;
        int j = 0;
        int[] next = getNextArray(target);
        while (i < n && j < m) {
            if (source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else if (next[j] == -1) {
                i++;
            } else {
                j = next[j];
            }
        }
        return j == m ? i - j : -1;
    }
    /**
     * 由target构造next数组，时间复杂度O(M)
     *
     * @param target
     * @return
     */
    public static int[] getNextArray(String target) {
        int len = target.length();
        if (len == 1) {
            return new int[]{-1};
        }
        int[] next = new int[len];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        // 向前跳的位置，初始时置0
        int cn = 0;
        while (i < len) {
            if (target.charAt(i - 1) == target.charAt(cn)) {
                next[i++] = ++cn;
            // 不等，继续往前跳
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
