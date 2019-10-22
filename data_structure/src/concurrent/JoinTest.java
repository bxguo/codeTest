package concurrent;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by bxguo on 2019/10/22 21:30
 */
public class JoinTest {
    public static void main(String[] args) {
        Sourceqwe source = new Sourceqwe();
        Thread t1 = new Thread(() -> {
            source.fun1();
        });
        Thread t2 = new Thread(() -> {
            source.fun2(t1);
        });
        Thread t3 = new Thread(() -> {
            source.fun2(t1);
        });
        t1.start();
        t2.start();
        t3.start();
    }
    static class Sourceqwe{
        public synchronized void fun1(){
            try {
                Thread.sleep(6000);
                System.out.println("fun1 run......");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public void fun2(Thread t){
            try {
                t.join(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("fun2 run......");
        }
        public void fun3(Thread t){
            try {
                t.join(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("fun3 run......");
        }

    }
}
