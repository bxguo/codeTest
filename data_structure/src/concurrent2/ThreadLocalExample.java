package concurrent2;

/**
 * Created by bxguo on 2019/8/20 23:29
 */
public class ThreadLocalExample {
    public static class MyRunnable implements Runnable {
        ThreadLocal<Object> threadLocal;
        public MyRunnable(ThreadLocal<Object> threadLocal) {
            this.threadLocal = threadLocal;
        }
        // MyRunnable 全局变量
        int random;

        @Override
        public void run() {
            random = (int) (Math.random() * 100D);
            threadLocal.set(random);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            System.out.println(threadLocal.get());threadLocal.remove();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable(new ThreadLocal<>());

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        System.out.println("thread1 start");
        thread2.start();
        System.out.println("thread2 start");

        thread1.join(); //wait for thread 1 to terminate
        System.out.println("thread1 join");
        thread2.join(); //wait for thread 2 to terminate
        System.out.println("thread2 join");
    }
}
