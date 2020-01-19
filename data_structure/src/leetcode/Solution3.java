package leetcode;

import java.util.*;

/**
 * Longest Substring Without Repeating Characters
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int max = solution3.lengthOfLongestSubstring2("abcaacbb");
        System.out.println(max);
    }

    /**
     * hashSet滑动窗口实现，通过逐个删除左侧元素来达到不存在重复元素的目的，因为没有直接跳到
     * 重复元素位置所以性能比下面的map实现稍差，但是更容易理解
     */

    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int length = s.length();
        int max = 0;
        while (i < length && j < length) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(j - i, max);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    /**
     * hashMap实现，
     */

    public int lengthOfLongestSubstring2(String s) {
        //"abcbacbb"
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            //map中存在当前字符如果是之前已经出现过两次的那么j直接跳到之前最后一次出现的额位置+1，
            //如果是第一次出现那么第一次位置+1
            //map的key是不重复的记录的永远都是当前元素最后一次出现的位置
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)) + 1, j);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring4(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            }
        }
        return max;
    }

    //暴力匹配,比较耗费内存
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int length = s.length();
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (unique(s, i, j)) {
                    max = Math.max(j - i + 1, max);
                }
            }
        }
        return max;
    }

    public boolean unique(String s, int start, int end) {
        List<Character> list = new ArrayList();
        while (start < end + 1) {
            char c = s.charAt(start);
            if (list.contains(c)) {
                return false;
            }
            list.add(c);
            start++;
        }
        return true;
    }
}
