package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通过它可以实现让一组线程等待至某个状态之后再全部同时执行
 * @author: bxguo
 * @time: 2019/3/22 11:09
 * 参考: https://www.cnblogs.com/dolphin0520/p/3920397.html
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        int N = 4;
        final ExecutorService exec = Executors.newFixedThreadPool(N);
        CyclicBarrier barrier  = new CyclicBarrier(N);
        exec.submit(() -> {
            readFiles(barrier);
        });
        exec.submit(() -> {
            readFiles(barrier);
        });
        exec.submit(() -> {
            readFiles(barrier);
        });
        exec.submit(() -> {
            readFiles(barrier);
        });

    }

    private static void readFiles(CyclicBarrier barrier) {
        System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
        try {
            Thread.sleep(5000);      //以睡眠来模拟写入数据操作
            System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
            barrier.await(); //需要N(4)个线程调用这个方法才会往下执行
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("所有线程写入完毕，继续处理其他任务...");
    }



    /*static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }*/
}
