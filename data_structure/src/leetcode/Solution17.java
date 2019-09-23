package leetcode;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author: bxguo
 * @time: 2019/9/22 10:16
 */
public class Solution17 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        System.out.println(solution17.letterCombinations("23"));
    }

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> output = new ArrayList<String>();
    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }
    public List<String> letterCombinations2(String digits) {

        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }


    private String[] strs = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        getLetter("", digits);
        return list;
    }
    public void getLetter(String item,  String remainDigits){
        if (remainDigits.length() == 0) {
            list.add(item);
        }else {
            String letters = strs[remainDigits.charAt(0) - '2'];
            for (int j = 0; j < letters.length(); j++) {
                getLetter(item + letters.charAt(j), remainDigits.substring(1));

            }
        }
    }
}
