package concurrent2.twostep;

/**
 * @author: bxguo
 * @time: 2019/7/12 16:58
 */
public class CountThread extends Thread {

    private boolean stop = false;
    private volatile int count;

    public void shutdown() {
        //this.stop = true;
        interrupt();
    }

    @Override
    public void run() {
        try {
            while (!stop) {
                count++;
                System.out.println("count : " + count);
                //Thread.sleep(100);

            }
            System.out.println("sadfadfa");

        /*} catch (InterruptedException | IllegalMonitorStateException e) {
            e.printStackTrace();*/
        }finally {
            System.out.println("终止  count：" + count);
        }
    }
}
