package sort;

import org.junit.Test;

/**
 * 插入排序:通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
 * @author: bxguo
 * @time: 2019/10/17 15:01
 */
public class Insertion {
    @Test
    public void sort() {
        int[] nums = {1,3,2,4,6,7,9,8,5,0};
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && SortUtils.less(nums[j], nums[j - 1]); j--) {
                SortUtils.swap(nums, j, j - 1);
            }
        }


    }
}
