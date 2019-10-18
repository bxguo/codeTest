package sort;

/**
 * 冒泡优化，如果某次内循环没有值移动说明该段已经排好序，可以撤了
 * @author: bxguo
 * @time: 2019/10/18 15:58
 */
public class BubbleSort {
    public  void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSort = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp = 0;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] nums = {0,1,3,2,4,6,7,9,8,5};
        bubbleSort.sort(nums);
        System.out.println(nums);
    }
}
