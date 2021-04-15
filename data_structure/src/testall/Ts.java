package testall;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 郭炳侠 on 2021/4/15.
 */
public class Ts {

    private static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        try {
            for (int i = 0; i < 1000; i++) {
                queue.offer("I" + i);
            }
            for (int i = 0; i < 10; i++) {
                service.execute(new Runnable() {
                    @Override
                    public void run() {
                        while (!queue.isEmpty()) {
                            System.out.println(queue.poll());
                        }
                    }
                });
            }
            for (int i = 0; i < 10; i++) {
                service.execute(new Runnable() {
                    @Override
                    public void run() {
                        queue.offer("el");
                    }
                });
            }
        } finally {
            service.shutdown();
        }
    }

}
