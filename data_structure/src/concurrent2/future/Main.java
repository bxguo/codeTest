package concurrent2.future;

/**
 * @author: bxguo
 * @time: 2019/7/8 16:32
 */
public class Main {
    public static void main(String[] args) {
        Host host = new Host();
        Data a = host.get("a");
        Data b = host.get("b");
        Data c = host.get("c");

        System.out.println(a.getContent());
        System.out.println(b.getContent());
        System.out.println(c.getContent());


    }
}
