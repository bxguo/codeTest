package concurrent2.ifwhile;

/**
 * @author: bxguo
 * @time: 2019/10/21 14:26
 */
public class testifw {
    public static void main(String[] args) {
        SynStack ss = new SynStack();
        Producer p = new Producer(ss);
        Consumer c = new Consumer(ss);


        Thread t1 = new Thread(p);
        t1.setName("1号");
        t1.start();
        /*Thread t2 = new Thread(p);
        t2.setName("2号");
        t2.start();*/

        Thread t6 = new Thread(c);
        t6.setName("6号");
        t6.start();
        Thread t7 = new Thread(c);
        t7.setName("7号");
        t7.start();
    }
}
