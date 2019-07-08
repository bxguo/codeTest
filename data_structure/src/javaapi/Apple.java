package javaapi;

import java.math.BigDecimal;

/**
 * @author: bxguo
 * @time: 2019/4/19 15:33
 */
public class Apple {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;
    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }
}
