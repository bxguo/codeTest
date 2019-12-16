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
        sort2(nums, 0, nums.length - 1);
        System.out.println(nums);
    }

    //快速排序
    private void sort(int[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        //nums[l]作为切割点，比它大的放右边比它小的放左边
        int v = nums[l];
        int i = l + 1, j = h;
        while (true) {
            //从左边开始直到找到一个大于等于nums[i]的值为止
            while (i != h && nums[i] < v) {
                i++;
            }
            //从左边开始直到找到一个小于等于nums[i]的值为止
            while (j != l && nums[j] > v) {
                j--;
            }
            //如果符合i < j，也就是上面两个循环没有重叠则交换上面发现的两个值，
            //使得小于等于nums[i]在左边，大于等于nums[i]在右边
            //循环完整个集合为止
            if (i < j) {
                SortUtils.swap(nums, i, j);
            }else {
                break;
            }
        }
        //将nums[i]放到对应的位置，以它为中心，切割出两个大于和小于它的数组
        //递归排序，直到h <= l（即集合里只有一个值）
        SortUtils.swap(nums, l, i - 1);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    //三向切分快速排序
    protected void sort2(int[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int v = nums[l];//基准值
        int lt = l, i = l + 1, gt = h;
        while (i <= gt) {
            if (nums[i] < v) {
                SortUtils.swap(nums, lt++, i++);
            } else if (nums[i] > v) {
                SortUtils.swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        sort2(nums, l, lt - 1);
        sort2(nums, gt + 1, h);
    }
}
