package testall;

/**
 * 数组最大不连续递增子序列
 * arr[] = {3,1,4,1,5,9,2,6,5}的最长递增子序列长度为4。即为：1,4,5,9
 * Created by 郭炳侠 on 2021/4/17.
 */
public class Dynamic1 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        System.out.println(Dynamic1.maxChildArrayOrder(arr));
    }
    public static int maxChildArrayOrder(int[] a) {
        int n = a.length;
        int[] temp = new int[n];//temp[i]代表0...i上最长递增子序列
        for (int i = 0; i < n; i++) {
            temp[i] = 1;//初始值都为1
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && temp[j] + 1 > temp[i]) {
                    //如果有a[i]比它前面所有的数都大，则temp[i]为它前面的比它小的数的那一个temp+1取得的最大值
                    temp[i] = temp[j] + 1;
                }
            }
        }
        int max = temp[0];
        //从temp数组里取出最大的值
        for (int i = 1; i < n; i++) {
            if (temp[i] > max) {
                max = temp[i];
            }
        }
        return max;
    }
}
