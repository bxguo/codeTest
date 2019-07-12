package concurrent2.twostep;

/**
 * @author: bxguo
 * @time: 2019/7/12 17:17
 */
public class Main {
    public static void main(String[] args) {
        CountThread countThread = new CountThread();
        countThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countThread.shutdown();
    }

}
