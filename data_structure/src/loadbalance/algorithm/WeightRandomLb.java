package loadbalance.algorithm;

import cn.hutool.core.util.RandomUtil;
import loadbalance.BaseLoadBalance;
import loadbalance.LoadBalance;
import loadbalance.Node;

import java.util.List;

/**
 * 加权随机
 */
public class WeightRandomLb extends BaseLoadBalance<Node> implements LoadBalance<Node> {
    @Override
    protected Node doSelect(List<Node> nodes, String ip) {
        int totalWeight = nodes.stream().mapToInt(Node::getWeight).sum();
        int flag = RandomUtil.randomInt(0, totalWeight - 1);
        int curWeight = 0;
        for (Node node : nodes) {
            curWeight = curWeight + node.getWeight();
            if (curWeight > flag) {
                return node;
            }
        }
        return RandomUtil.randomEle(nodes);
    }
}
