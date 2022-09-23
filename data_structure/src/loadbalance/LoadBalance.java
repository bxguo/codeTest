package loadbalance;

import java.util.List;

public interface LoadBalance<N extends Node> {
    N select(List<N> nodes, String ip);
}
