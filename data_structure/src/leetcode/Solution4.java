package leetcode;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * Created by bxguo on 2019/9/14 22:23
 */
public class Solution4 {

    //先归并在根据奇偶获取中位数
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        //step 1 假如数组nums1为空
        if (m == 0 && n != 0){
            return fun(nums2, n);
        }
        //step 2 假如数组nums2为空
        if (n == 0 && m != 0){
            return fun(nums1, m);
        }
        //step 3 假如数组均不为空，进行归并排序
        if (n != 0 && m != 0) {
            int[] aux = new int[m + n];
            int i = 0, j = 0;
            for (int k = 0; k < aux.length; k++) {
                if (i == m) {
                    aux[k] = nums2[j++];
                } else if (j == n) {
                    aux[k] = nums1[i++];
                } else if (nums1[i] > nums2[j]) {
                    aux[k] = nums2[j++];
                } else {
                    aux[k] = nums1[i++];
                }
            }
            return fun(aux, m + n);
        }
        return 0;
    }

    private double fun(int[] nums1, int length) {
        if (length % 2 == 0) {
            return (nums1[length / 2 - 1] + nums1[length / 2]) / 2.0;
        } else {
            return nums1[(length - 1) / 2];
        }
    }
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(solution4.findMedianSortedArrays2(nums1, nums2));
    }

    //TODO 最优解 log(min(n))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null){
            return -1;
        }
        int cut1 = nums1.length/2;
        int cut2 = (nums1.length + nums2.length) / 2 - cut1;
        if (nums1[cut1 - 1] > nums2[cut2]) {
            cut1--;
        }
        if (nums1[cut1] < nums2[cut2 - 1]) {
            cut1++;
        }

        return 0;
    }




    /*
     *  归并排序 demo
     *  大概思想是两个有序数组从头开始逐个比较，
     *  符合条件的元素放入辅助数组并且下表向前移动
     * 一个数组为空后将另一个数组逐个放进辅助数组
     */
    public abstract class MergeSort<T extends Comparable<T>> {

        protected T[] aux;


        protected void merge(T[] nums, int l, int m, int h) {

            int i = l, j = m + 1;

            for (int k = l; k <= h; k++) {
                aux[k] = nums[k]; // 将数据复制到辅助数组
            }

            for (int k = l; k <= h; k++) {

                //前两层判断为比较终止条件
                if (i > m) {
                    nums[k] = aux[j++];

                } else if (j > h) {
                    nums[k] = aux[i++];

                // 先进行这一步，保证稳定性
                } else if (aux[i].compareTo(aux[j]) <= 0) {
                    nums[k] = aux[i++];

                } else {
                    nums[k] = aux[j++];
                }
            }
        }
    }
}
