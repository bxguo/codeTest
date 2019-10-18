package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: bxguo
 * @time: 2019/10/17 17:24
 */
public class MergeSort {

    protected int[] aux;
    private void sort(int[] nums) {
        aux = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }
    private void sort(int[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int mid = l + (h - l) / 2;
        sort(nums, l, mid);
        sort(nums, mid + 1, h);
        merge(nums, l, mid, h);
    }
    protected void merge(int[] nums, int l, int m, int h) {
        List list = new ArrayList();
        int i = l, j = m + 1;
        for (int k = l; k <= h; k++) {
            aux[k] = nums[k];
        }
        for (int k = l; k <= h; k++) {
            if (i > m) {
                nums[k] = aux[j++];
            } else if (j > h) {
                nums[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
    }
}
