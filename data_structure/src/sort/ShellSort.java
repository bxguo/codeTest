package sort;

import org.junit.Test;

/**
 * @author: bxguo
 * @time: 2019/10/17 14:19
 */
public class ShellSort {
    @Test
    public void shellSort() {
        int[] nums = {1, 3, 2, 4, 6, 7, 9, 8, 5, 0};
        int N = nums.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, ...
        }
        while (h >= 1) {
            /*TODO 网上找的
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }*/
            //TODO 自己写的
            for (int i = 0; i < h; i++) {
                for (int j = h + i; j < N; j += h) {
                    while (j >= h + i && less(nums[j], nums[j - h])) {
                        swap(nums, j, j - h);
                        j -= h;
                    }
                }
            }
            h = h / 3;
        }
        System.out.println(nums);
    }

    protected void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected boolean less(int v, int w) {
        return v < w;
    }
}
