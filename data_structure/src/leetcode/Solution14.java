package leetcode;

/**
 * 给定一个排序的整数数组（升序）和一个要查找的整数target，
 * 用O(logn)的时间查找到target第一次出现的下标（从0开始），如果target不存在于数组中，返回-1。
 * @author: bxguo
 * @time: 2019/8/19 15:22
 */
public class Solution14 {
    public int binarySearch(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length;

        while (start <= end) {

            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                while (start < mid && nums[mid - 1] == target) {
                    mid = mid - 1;
                }
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    public int binarySearch2(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length;
        return this.search(nums,target,start,end);
    }
    /**
     * 递归算法
     */
    public int search(int[] nums, int target, int start, int end) {

        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            while (start < mid && nums[mid - 1] == target) {
                mid = mid - 1;
            }
            return mid;
        } else if (nums[mid] < target) {
            return search(nums, target, mid + 1, end);
        } else {
            return search(nums, target, start, mid - 1);
        }
    }
}
