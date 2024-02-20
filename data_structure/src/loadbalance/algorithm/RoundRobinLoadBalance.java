package loadbalance.algorithm;

import loadbalance.BaseLoadBalance;
import loadbalance.LoadBalance;
import loadbalance.Node;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 轮询算法
 */
public class RoundRobinLoadBalance extends BaseLoadBalance<Node> implements LoadBalance<Node> {

    private AtomicInteger position = new AtomicInteger(0);

    @Override
    protected Node doSelect(List<Node> list, String ip) {
        //存在原子问题
        // if (list.size() <= position.get()) {
        //   position.set(0);
        //}
        position.compareAndSet(list.size(), 0); //位置到最后一个的时候，重置到第一个
        Node node = list.get(position.get());
        position.getAndIncrement(); //位置顺位下一个
        return node;
    }

}
