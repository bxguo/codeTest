package leetcode;

/**
 * @author: bxguo
 * @time: 2019/7/23 16:41
 */
public class AnswerTest {
    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        int[] nums={1,4,4,5,7,7,8,9,9,10};
        int target = 1;
        System.out.println(solution.binarySearch2(nums, target));
    }
}
