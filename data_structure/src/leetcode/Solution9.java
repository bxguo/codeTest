package leetcode;

import com.sun.org.apache.bcel.internal.generic.LDIV;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 *
 * @author: bxguo
 * @time: 2019/9/16 9:49
 */
public class Solution9 {


    //数字反转
    public boolean isPalindrome3(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int num = 0;

        while (num < x) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        return num == x || num / 10 == x;
    }

    /**
     * 取模取余解法
     * @param x
     * @return
     */
    public boolean isPalindrome4(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        while (x / div >= 10) {
            div = div * 10;
        }
        while (div > 0) {
            if (x / div != x % 10) {
                return false;
            }
            //x = (x - x / div * div)/10;
            x = (x % div) / 10;
            if (x < 10) {
                return true;
            }
            div = div / 10;
        }
        return false;
    }

    /**
     * 转化字符串解法
     */
    public boolean isPalindrome2(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = x + "";
        int length = str.length();
        int i = 0;
        int j = length - 1;
        int num = 0;
        while (j - i > 0) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
                num++;
            }else {
                return false;
            }
        }
        if (length - 2 * num < 2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        System.out.println(solution9.isPalindrome3(121));
    }
}
