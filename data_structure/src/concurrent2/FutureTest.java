package concurrent2;

/**
 * @author: bxguo
 * @time: 2019/7/8 16:16
 */
public class FutureTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            int count = 0;
            /*while (true){
                count++;
                System.out.println("count : "+count);*/
                try {
                    Thread.currentThread().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("sdfadf");
                }
            //}
        });
        thread.start();
        try {
            Thread.sleep(3000);
            System.out.println("main run");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
