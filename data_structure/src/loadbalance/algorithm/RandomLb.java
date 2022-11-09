package loadbalance.algorithm;

import cn.hutool.core.util.RandomUtil;
import loadbalance.BaseLoadBalance;
import loadbalance.LoadBalance;
import loadbalance.Node;

import java.util.List;

/**
 * 普通随机
 */
public class RandomLb extends BaseLoadBalance<Node> implements LoadBalance<Node> {
    @Override
    protected Node doSelect(List<Node> list, String ip) {
        return RandomUtil.randomEle(list);
    }
}
