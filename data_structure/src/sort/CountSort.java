package sort;

/**
 * bug
 * 不适用数组中包含0的
 * 最大值太大的不适用
 *
 * @author: bxguo
 * @time: 2019/10/19 10:17
 */
public class CountSort {
    public void sort(){
        int[] arr = {1, 3, 2, 4, 6, 7, 9, 8, 5, 4};
        int max = 0;
        //取最大值
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        //初始化计数数组
        int[] countarr = new int[max + 1];
        for (int value : arr) {
            countarr[value]++;
        }
        //排序
        int index = 0;
        for (int i = 0; i < countarr.length; i++) {
            if (countarr[i] > 0) {
                for (int j = 0; j < countarr[i]; j++) {
                    arr[index++] = i;
                }
            }
        }
        System.out.println(arr);
    }

    public static void main(String[] args) {
        CountSort countSort = new CountSort();
        countSort.sort();
    }
}
