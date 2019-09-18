package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: bxguo
 * @time: 2019/9/18 9:45
 */
public class Solution12 {
    static Map<Integer, String> map = new HashMap<Integer, String>();
    {
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
    }
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }
        StringBuilder aux = new StringBuilder();
        int div = 1;
        while (num / div >= 10) {
            div *= 10;
        }
        while (div > 0 && num > 0) {
            String s = map.get(div);
            int cur = num / div;
            if (cur == 0) {
                num %= div;
                div /= 10;
                continue;
            } else if (cur < 4) {
                for (int i = 0; i < cur; i++) {
                    aux.append(s);
                }
            } else if (cur > 4 && cur < 9) {
                aux.append(map.get(div * 5));
                for (int i = 0; i < cur - 5; i++) {
                    aux.append(s);
                }
            } else if (cur == 4) {
                aux.append(s).append(map.get(div * 5));
            } else {
                aux.append(s).append(map.get(div * 10));
            }
            num %= div;
            div /= 10;
        }
        return aux.toString();
    }

    /**
     * 贪心算法 解法
     * @param num
     * @return
     */
    public String intToRoman2(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < nums.length) {
            while (num >= nums[index]) {
                sb.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return sb.toString();
    }
        public static void main(String[] args) {

        Solution12 solution12 = new Solution12();
        System.out.println(solution12.intToRoman2(3));
        System.out.println(solution12.intToRoman2(4));
        System.out.println(solution12.intToRoman2(9));
        System.out.println(solution12.intToRoman2(58));
        System.out.println(solution12.intToRoman2(1994));
        System.out.println(solution12.intToRoman2(101));
    }
}
