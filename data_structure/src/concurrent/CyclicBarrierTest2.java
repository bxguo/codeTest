package concurrent;

import java.util.concurrent.*;

/**
 * @author: bxguo
 * @time: 2019/3/22 17:07
 */
public class CyclicBarrierTest2 {
    public static void main(String[] args) {
        //步数
        int count = 10;
        final CyclicBarrier barrier = new CyclicBarrier(count );
        int[] datas = new int[1024];
        //步大小
        int step = datas.length / count;
        for (int i = 0; i < count; i++) {
            int start = i * step;
            int end = i == count - 1 ? datas.length - 1 : (i + 1) * step;

            ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 3,
                    TimeUnit. SECONDS, new ArrayBlockingQueue<>(3),
                    new ThreadPoolExecutor.DiscardOldestPolicy());
            threadPool.execute(() -> {
                System.out.println("分段排序中---");
                try {
                    Thread.sleep(1000);
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        try {
            System.out.println("合并排序中---");
            Thread.sleep(1000);
            System.out.println("排序完成---");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
