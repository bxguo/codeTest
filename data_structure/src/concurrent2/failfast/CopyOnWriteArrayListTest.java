package concurrent2.failfast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: bxguo
 * @time: 2020/1/14 9:46
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        List<Integer> integers = new CopyOnWriteArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        Iterator<Integer> itr = integers.iterator();
        while (itr.hasNext()) {
            if (itr.next() == 2) {
                itr.remove();
            }
        }
        System.out.println(integers);

    }
}
