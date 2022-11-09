package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 source 、一个字符串 target 。返回 source 中涵盖 target 所有字符的最小子串。如果 source 中不存在涵盖 target 所有字符的子串，则返回空字符串 "" 。
 * <p>
 *  
 * <p>
 * 注意：
 * <p>
 * 对于 target 中重复字符，我们寻找的子字符串中该字符数量必须不少于 target 中该字符数量。
 * 如果 source 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */
public class Solution76 {

    private Map<Character, Integer> osi = new HashMap<>(); // 存储字符串t中每个字符和每个字符出现的次数
    private Map<Character, Integer> cnt = new HashMap<>(); // 动态存储截取的字符串中每个字符包含的个数


    public String minWindow(String source, String target) {
        int tLen = target.length();
        for (int i = 0; i < tLen; i++) {
            char a = target.charAt(i);
            osi.put(a, osi.getOrDefault(a, 0) + 1);
        }
        int sLen = source.length();
        int l = 0, r = -1;
        int ansL = -1, ansR = -1, len = Integer.MAX_VALUE;
        while (r < sLen) {
            ++r;
            if (r < sLen && osi.containsKey(source.charAt(r))) {
                cnt.put(source.charAt(r), cnt.getOrDefault(source.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                // 判断当前开头字符是否是t中所含字符
                if (osi.containsKey(source.charAt(l))) {  // 开始滑动窗口
                    cnt.put(source.charAt(l), cnt.getOrDefault(source.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : source.substring(ansL, ansR);
    }

    public boolean check() {
        for (Map.Entry<Character, Integer> entry : osi.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (cnt.getOrDefault(key, 0) < value) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        String window = solution76.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(window);
    }
}
