package loadbalance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Node {

    private String url;

    public Node(String url, Integer weight) {
        this.url = url;
        this.weight = weight;
    }

    private Integer weight;

    private Integer active;



}
