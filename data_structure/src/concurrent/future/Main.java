package concurrent.future;

/**
 * Created by bxguo on 2019/10/23 15:40
 */
public class Main {
    public static void main(String[] args) {
        Host host = new Host();
        Date a = host.request(1, "aaa");
        Date b = host.request(1, "bbb");
        Date c = host.request(1, "ccc");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getContent());
        System.out.println(b.getContent());
        System.out.println(c.getContent());
    }
}
