package testall;

/**
 * Created by bxguo on 2019/7/3 22:35
 */
public class Main {
    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        while (true) {
            testThread.start();
        }
    }
}
