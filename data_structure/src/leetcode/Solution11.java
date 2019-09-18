package leetcode;

/**
 * 盛最多水的容器
 *给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * @author: bxguo
 * @time: 2019/9/17 16:17
 */
public class Solution11 {

    /**
     * O(n^2)
     */
    public int maxArea(int[] height) {
        int length = height.length;
        int max = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                max = Math.max(max,Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

    /**
     * 双指针法
     */
    public int maxArea2(int[] height) {

        int left = 0, right = height.length - 1;
        int area = 0;
        while (right > left) {
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            }else {
                left++;
            }
        }
        return area;
    }
}
