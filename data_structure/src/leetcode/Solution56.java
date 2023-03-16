package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author bxguo
 */
public class Solution56 {
    /**
     * 数组计数法（未通过）
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        int min = 0, max = 0;
        for (int[] interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[1]);
        }
        int[] arr = new int[max + 2];
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            for (int i = start; i <= end; i++) {
                arr[i] = 1;
            }
        }
        arr[max + 1] = 0;
        int[][] res = new int[intervals.length][2];
        int poi = 0;
        int[] temp = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1 && temp == null) {
                temp = new int[2];
                temp[0] = i;
            }
            if (arr[i] == 0 && temp != null){
                temp[1] = i - 1;
                res[poi] = temp;
                poi++;
                temp = null;
            }
        }
        int[][] rec = new int[poi][2];
        for (int i = 0; i < rec.length; i++) {
            rec[i] = res[i];
        }
        return rec;
    }

    public int[][] merge2(int[][] intervals) {
        List<int[]> inter = Arrays.asList(intervals);
        List<int[]> newInter = new ArrayList<>(inter);
        newInter.sort(Comparator.comparingInt(o -> o[0]));

        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < newInter.size(); ) {
            int t = newInter.get(i)[1];
            int j = i + 1;
            while(j < newInter.size() && newInter.get(j)[0] <= t) {
                t = Math.max(t, newInter.get(j)[1]);
                j++;
            }
            res.add(new int[]{newInter.get(i)[0], t});
            i = j;
        }

        int[][] ans = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        int[][] param = new int[][]{{1,4},{5,6}};
        int[][] merge = solution56.merge(param);
    }
}
