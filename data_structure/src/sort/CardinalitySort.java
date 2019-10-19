package sort;

import java.util.ArrayList;

/**
 * @author: bxguo
 * @time: 2019/10/19 12:11
 */
public class CardinalitySort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 6, 7, 9, 8, 5, 4};
        CardinalitySort cardinalitySort = new CardinalitySort();
        cardinalitySort.sort(arr);
        System.out.println(arr);
    }
    public void sort(int[] arr) {
        //最大值
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        //当前排序位置
        int location = 1;

        //桶列表
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();

        //长度为10 装入余数0-9的数据
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList());
        }

        while (true) {
            //判断是否排完
            int dd = (int) Math.pow(10, (location - 1));
            if (max < dd) {
                break;
            }

            //数据入桶
            for (int value : arr) {
                //计算余数 放入相应的桶
                int number = ((value / dd) % 10);
                bucketList.get(number).add(value);
            }

            //写回数组
            int nn = 0;
            for (int i = 0; i < 10; i++) {
                int size = bucketList.get(i).size();
                for (int ii = 0; ii < size; ii++) {
                    arr[nn++] = bucketList.get(i).get(ii);
                }
                bucketList.get(i).clear();
            }
            location++;
        }
    }
}
