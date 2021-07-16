package testall.block;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by 郭炳侠 on 2021/4/20.
 */
public class Consumer implements Runnable {
    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME = 3000;
    public Consumer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start Consumer id :"+Thread.currentThread().getId());
        Random r = new Random();
        try{
            while(true){
                PCData data = queue.take();
                int re = data.getData() * data.getData();
                System.out.println(MessageFormat.format("{0}*{1}={2}", data.getData(),data.getData(),re));
                Thread.sleep(r.nextInt(SLEEPTIME));
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

}
