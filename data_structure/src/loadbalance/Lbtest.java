package loadbalance;

import cn.hutool.json.JSONUtil;
import loadbalance.algorithm.WeightRandomLb;
import loadbalance.algorithm.WeightRoundRobinLoadBalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lbtest {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node("111",1));
        nodes.add(new Node("222",2));
        nodes.add(new Node("333",3));
        nodes.add(new Node("444",4));
        WeightRoundRobinLoadBalance lb = new WeightRoundRobinLoadBalance();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            Node select = lb.select(nodes, "");
            System.out.printf("选中===: %s", select.getUrl());
            System.out.println("");
            Integer count = map.get(select.getUrl());
            count = count == null ? 1 : ++count;
            map.put(select.getUrl(), count);
        }
        System.out.println(JSONUtil.toJsonPrettyStr(map));

    }
}
