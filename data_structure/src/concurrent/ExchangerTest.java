package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author: bxguo
 * @time: 2019/3/27 15:53
 */
public class ExchangerTest {
    final static Exchanger<List<Integer>> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(() -> {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            List<Integer> exchange = null;
            try {
                exchange = exchanger.exchange(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----第一个队列");
            exchange.forEach(System.out::println);
        }).start();
        new Thread(() -> {
            List<Integer> list = new ArrayList<>();
            list.add(3);
            list.add(4);
            List<Integer> exchange = null;
            try {
                exchange = exchanger.exchange(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----第二个队列");
            exchange.forEach(System.out::println);
        }).start();
    }

}
