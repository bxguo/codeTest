package concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: bxguo
 * @time: 2019/3/22 17:07
 */
public class CyclicBarrierTest2 {
    public static void main(String[] args) {
        //步数
        int count = 10;
        final CyclicBarrier barrier = new CyclicBarrier(count + 1);
        int[] datas = new int[1024];
        //步大小
        int step = datas.length / count;
        for (int i = 0; i < count; i++) {
            int start = i * step;
            int end = i == count - 1 ? datas.length - 1 : (i + 1) * step - 1;


            //ThreadPoolExecutor tp
        }
    }
}
