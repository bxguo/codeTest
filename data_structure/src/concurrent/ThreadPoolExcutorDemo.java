package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: bxguo
 * @time: 2019/3/26 13:45
 */
public class ThreadPoolExcutorDemo {
    private static int produceTaskSleepTime = 5;
    private static int consumeTaskSleepTime = 500;
    private static int produceTaskMaxNumber = 20; //定义最大添加10个线程到线程池中

    public static void main(String[] args) {
        //构造一个线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 20, 30,
                TimeUnit. SECONDS, new ArrayBlockingQueue<Runnable>(3),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        for( int i=1; i<= produceTaskMaxNumber;i++){
            try {
                //一个任务，并将其加入到线程池
                String work= "work@ " + i;
                System. out.println( "put ：" +work);
                threadPool.execute( new ThreadPoolTask(work));
                //便于观察，等待一段时间
                Thread. sleep(produceTaskSleepTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadPoolTask implements Runnable {
        private static final long serialVersionUID = 0;
        //保存任务所需要的数据
        private Object threadPoolTaskData;
        ThreadPoolTask(Object works){
            this. threadPoolTaskData =works;
        }
        public void run(){
            //处理一个任务，这里的处理方式太简单了，仅仅是一个打印语句
            System.out.println("start------ " + threadPoolTaskData + Thread.currentThread().getName());
            try {
                //便于观察，等待一段时间
                Thread. sleep(consumeTaskSleepTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
            threadPoolTaskData = null;
        }
        public Object getTask(){
            return this. threadPoolTaskData;
        }
    }
}
