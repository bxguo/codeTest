package concurrent2.two_phase;

/**
 * Created by bxguo on 2019/7/11 22:53
 */
public class CountupThread extends Thread {

    private long count = 0;

    private boolean shutdowned;

    public void shutdownReq() {
        //shutdowned = true;
        interrupt();
    }


    @Override
    public void run() {
        try {
            wait();
            while (!shutdowned) {
                count++;
                System.out.println("count = " + count);
                Thread.sleep(1000);
            }

        } catch (InterruptedException | IllegalMonitorStateException e) {
            e.printStackTrace();
            System.out.println("111111111"+Thread.currentThread().isInterrupted());
        } finally {
            System.out.println("222222222"+Thread.currentThread().isInterrupted());
            System.out.println("终止进行中：count=" + count);
        }
    }
}
