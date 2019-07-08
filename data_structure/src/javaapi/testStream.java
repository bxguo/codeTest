package javaapi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: bxguo
 * @time: 2019/4/19 15:30
 */
public class testStream {


    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
        Apple apple12 = new Apple(1,"苹果2",new BigDecimal("1.35"),20);
        Apple apple2 =  new Apple(2,"香蕉",new BigDecimal("2.89"),30);
        Apple apple3 =  new Apple(3,"荔枝",new BigDecimal("9.99"),40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);
        appleList.remove(apple1);

        System.out.println((long) appleList.size() >0);


    }

}
