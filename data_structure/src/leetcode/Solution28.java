package leetcode;

import javax.jws.soap.SOAPBinding;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * @author: bxguo
 * @time: 2019/10/3 17:46
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if ("".equals(needle) || haystack.equals(needle)) {
            return 0;
        }
        for (int i = 0; i < haystack.length()-needle.length(); i++) {
            int j = 0;
            while (j < needle.length()) {
                if (haystack.charAt(i + j) == needle.charAt(j)) {
                    j++;
                    if (j == needle.length()) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "a";
        String needle = "";
        Solution28 solution28 = new Solution28();
        int i = solution28.strStr(haystack, needle);
        System.out.println(i);
    }
}
