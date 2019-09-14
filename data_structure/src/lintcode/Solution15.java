package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数字列表，返回其所有可能的排列。
 * @author: bxguo
 * @time: 2019/8/20 9:36
 */
public class Solution15 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), results);

        return results;
    }

    /**
     * 深度优先搜索算法
     * 使用 visited 数组记录某个数是否被放到 permutation 里了。
     */
    private void dfs(int[] nums,
                     boolean[] visited,
                     List<Integer> permutation,
                     List<List<Integer>> results) {
        if (nums.length == permutation.size()) {
            results.add(permutation);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, results);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }


}
