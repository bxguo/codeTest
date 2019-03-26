package concurrent.shutdownpac;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: bxguo
 * @time: 2019/3/26 15:32
 */
public class WaitqueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        for(int i = 1; i <= 100 ; i++){
            workQueue.add(new Task(String.valueOf(i)));
        }
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, workQueue);
        executor.execute(new Task("0"));
        // shutdownNow有返回值，返回被抛弃的任务list
        Thread.sleep(1000);
        //执行完shutdownNow后线程池中的线程都会中断
        List<Runnable> dropList = executor.shutdownNow();
        System.out.println("workQueue size = " + workQueue.size() + " after shutdown");
        System.out.println("dropList size = " + dropList.size());
    }

    static class Task implements Runnable{
        String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for(int i = 1; i <= 10; i++){
                System.out.println("task " + name + " is running");
            }
            System.out.println("task " + name + " is over");
        }
    }
}
