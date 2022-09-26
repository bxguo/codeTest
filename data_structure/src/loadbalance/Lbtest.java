package loadbalance;

import cn.hutool.json.JSONUtil;
import loadbalance.algorithm.WeightRandomLb;

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
        WeightRandomLb lb = new WeightRandomLb();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            Node select = lb.select(nodes, "");
            Integer count = map.get(select.getUrl());
            count = count == null ? 1 : ++count;
            map.put(select.getUrl(), count);
        }
        System.out.println(JSONUtil.toJsonPrettyStr(map));

    }
}
