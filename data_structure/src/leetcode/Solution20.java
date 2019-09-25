package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: '()'
 * 输出: true
 *
 * @author: bxguo
 * @time: 2019/9/25 9:25
 */
public class Solution20 {
    private Map<Character, Character> mappings = new HashMap<Character, Character>(){{
        put(')', '(');
        put('}', '{');
        put(']', '[');
    }};
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    /* TODO 错误解
   public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        return fun(s);
    }

    private boolean fun(String s) {
        int l = 0, r = 1;
        while (r < s.length()) {
            if (mappings.containsKey(s.charAt(l))) {
                if (mappings.get(s.charAt(l)) == s.charAt(r)) {
                    break;
                }
            } else {
                return false;
            }
            l++;
            r++;
        }
        int end = r + l;
        if (end > s.length() - 1) {
            return false;
        }
        if (mappings.get(s.charAt(l)) == s.charAt(r)) {
            String lstr = s.substring(0, l);
            String rstr = s.substring(r + 1, end + 1);
            for (int i = 0; i < l; i++) {
                if (!mappings.containsKey(lstr.charAt(i)) || mappings.get(lstr.charAt(i)) != rstr.charAt(l - i - 1)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        if (end < s.length() - 1) {
            return fun(s.substring(end + 1));
        }
        return true;
    }*/

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        String s = "(([]){})(([]){})";
        System.out.println(solution20.isValid(s));
    }
}
