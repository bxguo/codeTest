package leetcode;

import com.google.common.cache.CacheBuilder;

import java.util.*;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Created by bxguo on 2019/4/12 22:46
 */
public class Solution3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring3("pwwkew"));
    }

    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    private static int lengthOfLongestSubstring2(String s) {
        List<Character> temp = new ArrayList<Character>();
        int max = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                char ch = s.charAt(j);
                if (!temp.contains(ch)) {
                    temp.add(ch);
                    continue;
                }
                break;
            }
            max = temp.size() > max ? temp.size() : max;
            temp.clear();
        }
        return max;
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        List temp = new ArrayList();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (!temp.contains(chars[j])) {
                    temp.add(chars[j]);
                    continue;
                }
                break;
            }
            max = temp.size() > max ? temp.size() : max;
            temp = new ArrayList();
        }
        return max;
    }
}
