package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 郭炳侠
 * @date 2021/12/3
 */
public class TheadPooltest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 20, 30,
                TimeUnit. SECONDS, new ArrayBlockingQueue<Runnable>(1),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for( int i=1; i<= 20;i++){
            try {
                //一个任务，并将其加入到线程池
                String work= "work@ " + i;
                System. out.println( "put ：" +work);
                threadPool.execute( new ThreadPoolExcutorDemo.ThreadPoolTask(work));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
