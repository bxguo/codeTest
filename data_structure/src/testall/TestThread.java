package testall;

/**
 * Created by bxguo on 2019/7/3 22:33
 */
public class TestThread extends Thread {
    @Override
    public void run() {
        System.out.print("BEGIN");
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("END");
    }
}
