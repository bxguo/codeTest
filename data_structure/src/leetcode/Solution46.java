package leetcode;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 郭炳侠
 * @date 2021/10/13
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Object> linkedList = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), res);
        return res;
    }

    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> permute = solution46.permute(nums);
        System.out.println(JSONUtil.toJsonStr(permute));
    }


    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    /**
     * 1选择列表 2路径 3
     * @param nums
     * @param track
     * @param res
     */
    void backtrack(int[] nums, List<Integer> track, List<List<Integer>> res) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track, res);
            track.remove(track.size() - 1);
        }
    }
}
