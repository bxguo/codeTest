package concurrent;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 郭炳侠 on 2021/6/28.
 */
public class SimpleBlockingQueueTest {
    private final List<Object> queue = new LinkedList<>();
    private final int limit;

    public SimpleBlockingQueueTest(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(Object item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            print("队列已满，等待中...");
            wait();
        }
        this.queue.add(item);
        if (this.queue.size() == 1) {
            notifyAll();
        }
        print(item, "已经放入！");
    }


    public synchronized Object dequeue() throws InterruptedException {
        while (this.queue.size() == 0) {
            print("队列空的，等待中...");
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        Object item = this.queue.get(0);
        print(item, "已经拿到！");
        return this.queue.remove(0);
    }

    public static void print(Object... args) {
        StringBuilder message = new StringBuilder(getThreadName() + ":");
        for (Object arg : args) {
            message.append(arg);
        }
        System.out.println(message);
    }

    public static String getThreadName() {
        return Thread.currentThread().getName();
    }


    public static void main(String[] args) {
        SimpleBlockingQueueTest blockingQueue = new SimpleBlockingQueueTest(10);
        Thread lanLingWang = new Thread(() -> {
            try {
                String[] items = { "A", "B", "C", "D", "E" };
                for (String item: items) {
                    Thread.sleep(500);
                    blockingQueue.enqueue(item);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        lanLingWang.setName("兰陵王");
        Thread niumo = new Thread(() -> {
            try {
                while (true) {
                    blockingQueue.dequeue();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        lanLingWang.setName("兰陵王");
        niumo.setName("牛魔王");

        lanLingWang.start();
        niumo.start();
    }
}
