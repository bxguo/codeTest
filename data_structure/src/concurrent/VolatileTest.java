package concurrent;

/**
 * @author: bxguo
 * @time: 2019/11/14 15:28
 */
public class VolatileTest {

    //加不加volatile两种不同的效果
    private static volatile int value = 0;
    private static int MAX = 5;


    public static void main(String[] args) {
        new Thread(() -> {
            int temp = value;
            while (temp < MAX) {
                if (temp != value) {
                    System.out.println(value);
                    temp = value;
                }
            }
        }).start();

        new Thread(() -> {
            int temp = value;
            while (temp < MAX) {
                try {
                    System.out.println("value is change to :" + (++temp));
                    value = temp;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
