package loadbalance;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;

import java.util.List;

public abstract class BaseLoadBalance<N extends Node> implements LoadBalance<N> {
    @Override
    public N select(List<N> list, String ip) {
        if (CollUtil.isEmpty(list)) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
       return doSelect(list, ip);
    }

    protected abstract N doSelect(List<N> list, String ip);

}
