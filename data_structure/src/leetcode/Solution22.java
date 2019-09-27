package leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()() "
 * ]
 * @author: bxguo
 * @time: 2019/9/26 14:12
 */

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>(2 * n);
        backtrack(ans, "", 0, 0, n);
        return ans;
    }
    private void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
        }else {
            if (open < max) {
                backtrack(ans, cur+"(", open+1, close, max);
            }
            if (close < open) {
                backtrack(ans, cur+")", open, close+1, max);
            }
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left: generateParenthesis2(c)) {
                    for (String right : generateParenthesis2(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        System.out.println(solution22.generateParenthesis(3));


    }
}
