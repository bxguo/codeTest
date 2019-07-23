package concurrent2;

/**
 * Created by bxguo on 2019/7/17 23:16
 */
public class JVMDemoTest {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int free = (int) (runtime.freeMemory() / 1024 / 1024);
        int total = (int) (runtime.totalMemory() / 1024 / 1024);
        System.out.println("free" + free);
        System.out.println("total" + total);
    }
}
