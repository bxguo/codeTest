package testall;

import java.util.concurrent.*;

/**
 * Created by 郭炳侠 on 2021/4/15.
 */
public class Ts {

    private final static BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        try {
            for (int i = 0; i < 2; i++) {
                service.execute(() -> {
                    try {
                        while (true) {
                            System.out.println(Thread.currentThread().getName()+"::"+queue.take());
                            //Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
            for (int i = 0; i < 10; i++) {
                service.execute(() -> {
                    try {
                        while (true) {
                            if (queue.offer("el", 2, TimeUnit.SECONDS)) {
                                System.out.println(Thread.currentThread().getName()+"::"+"queue.put(\"el\"); 失败  ");
                            }else {
                                System.out.println(Thread.currentThread().getName()+"::"+"queue.put(\"el\");");
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }

}
