package leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: bxguo
 * @time: 2019/9/19 10:13
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0 || "".equals(strs[0])) {
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        int i = 0;
        while (true) {
            int match = 0;
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].length() > i && strs[j + 1].length() > i && strs[j].charAt(i) == strs[j + 1].charAt(i)) {
                    match++;
                } else {
                    break;
                }
            }
            if (match == strs.length - 1) {
                i++;
            }else {
                return strs[0].substring(0, i);
            }
        }
    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        String[] strs = new String[]{"c","c"};
        System.out.println(solution14.longestCommonPrefix(strs));
    }
}
