package concurrent2.two_phase;

import concurrent2.two_phase.CountupThread;

/**
 * @author: bxguo
 * @time: 2019/7/8 16:16
 */
public class FutureTest {
    public static void main(String[] args) {
        CountupThread countupThread = new CountupThread();
        countupThread.start();
        try {
            Thread.sleep(5000);
            countupThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countupThread.shutdownReq();
        System.out.println(countupThread.isInterrupted());

    }


}
