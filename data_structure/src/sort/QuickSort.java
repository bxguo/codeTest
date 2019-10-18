package sort;

import org.junit.Test;

/**
 * 快速排序
 * 快速排序最好的情况下是每次都正好将数组对半分，这样递归调用次数才是最少的。这种情况下比较次数为 CN=2CN/2+N，复杂度为 O(NlogN)。
 *
 * 最坏的情况下，第一次从最小的元素切分，第二次从第二小的元素切分，如此这般。因此最坏的情况下需要比较 N2/2。为了防止数组最开始就是有序的，在进行快速排序时需要随机打乱数组。
 * @author: bxguo
 * @time: 2019/10/18 9:34
 */
public class QuickSort {
    @Test
    public void sort() {
        int[] nums = {1, 3, 2, 4, 6, 7, 9, 8, 5, 0};
        sort(nums, 0, nums.length - 1);
        System.out.println(nums);
    }

    private void sort(int[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int v = nums[l];
        int i = l + 1, j = h;
        while (true) {
            while (i != h && nums[i] < v) {
                i++;
            }
            while (j != l && nums[j] > v) {
                j--;
            }
            if (i < j) {
                SortUtils.swap(nums, i, j);
            }else {
                break;
            }
        }
        SortUtils.swap(nums, l, i - 1);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }
}
