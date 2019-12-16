package concurrent.AQS;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by bxguo on 2019/11/16 23:22
 */
public class AQSTest {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread( () -> {
            fun();
        },"thread 1").start();
        new Thread( () -> {
            fun();
        },"thread 2").start();
    }


    public static void fun(){
        int num = 0;
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "---fun---:" + num++);
            }
            System.out.println("-------");
        } finally {
            lock.unlock();
        }
    }
}
