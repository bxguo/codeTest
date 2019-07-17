package concurrent2.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author: bxguo
 * @time: 2019/7/8 16:32
 */
public class Main {
    public static void main(String[] args) {
        Host host = new Host();
        Data a = host.get2("a");
        Data b = host.get2("b");
        Data c = host.get2("c");

        System.out.println(a.getContent());
        System.out.println(b.getContent());
        System.out.println(c.getContent());
    }
}
