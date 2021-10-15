package leetcode;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 郭炳侠
 * @date 2021/10/11
 */
public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] trace = new char[n][n];
        for (int i = 0; i < trace.length; i++) {
            Arrays.fill(trace[i], '.');
        }
        backtrack(res, trace, 0);
        return res;
    }

    void backtrack(List<List<String>> res, char[][] trace, int n) {
        if (trace.length == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < trace.length; i++) {
                temp.add(String.copyValueOf(trace[i]));
            }
            res.add(temp);
            return;
        }
        for (int j = 0; j < trace[n].length; j++) {
            if (check(trace, n, j)) {
                Arrays.fill(trace[n], '.');
                trace[n][j] = 'Q';
                backtrack(res, trace, n + 1);
                trace[n][j] = '.';
            }
        }
    }

    /**
     * @param trace 已摆好的皇后
     * @param row   行
     * @param col   列表
     * @return 当前位置是否可以放皇后
     */
    private boolean check(char[][] trace, int row, int col) {
        int n = trace.length;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (trace[i][col] == 'Q')
                return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (trace[i][j] == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (trace[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        List<List<String>> lists = solution51.solveNQueens(4);
        System.out.println(JSONUtil.toJsonPrettyStr(lists));
    }
}
