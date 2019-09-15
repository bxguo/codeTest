package leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by bxguo on 2019/9/15 22:28
 */
public class Solution7 {
    /*
     * 用模10取余的方式取得每一个字面量
     * 越界问题要注意
     */
    public int reverse(int x) {
        long res = 0L;
        while (x != 0) {
            res = res * 10 + x % 10;
             x /= 10;
            if (res>Integer.MAX_VALUE || res<Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int)res;
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        System.out.println(solution7.reverse(1534));
    }
}
