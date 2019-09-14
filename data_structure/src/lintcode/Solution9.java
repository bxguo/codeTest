package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：
 *
 * 如果这个数被3整除，打印fizz.
 * 如果这个数被5整除，打印buzz.
 * 如果这个数能同时被3和5整除，打印fizz buzz.
 * 如果这个数既不能被 3 整除也不能被 5 整除，打印数字本身。
 *
 * @author: bxguo
 * @time: 2019/7/29 15:49
 */
public class Solution9 {


    /**
     * 利用&&的截断功能，即前面不符合后边不会在执行
     */
    public List<String> fizzBuzz3(int n) {
        List<String> ret = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            String str = null;
            boolean bool1 = i % 3 == 0 && (str = "fizz") != null;
            boolean bool2 = i % 5 == 0 && (str = "buzz") != null && i % 3 == 0 && (str = "fizz buzz") != null;
            if (str == null) {
                ret.add("" + i);
            } else {
                ret.add(str);
            }
        }

        return ret;
    }


    /**
     * 预存储将15以内的fizz，buzz放到map中，然后对n取余15判断看有没有在map里面
     */
    public static HashMap<Integer,String> map = new HashMap<>();
    static{
        map.put(3,"fizz");
        map.put(6,"fizz");
        map.put(9,"fizz");
        map.put(12,"fizz");
        map.put(5,"buzz");
        map.put(10,"buzz");
        map.put(0,"fizz buzz");
    }
    public List<String> fizzBuzz2(int n) {
        List<String> ret = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int key = i % 15;
            if (map.containsKey(key)) {
                ret.add(map.get(key));
            } else {
                ret.add("" + i);
            }
        }
        return ret;
    }


    /**
     * 利用倍数关系
     */
    public List<String> fizzBuzz(int n) {
        // write your code here
        ArrayList<String> results = new ArrayList<String>();
        int i = 1;
        //p3表示3的多少倍，p5表示5的多少倍
        int p3 = 1, p5 = 1;

        while (i <= n) {
            while (i < p3 * 3 && i < p5 * 5) {
                results.add(i + "");
                i++;
            }

            if (i <= n && p3 * 3 == p5 * 5) {
                results.add("fizz buzz");
                p3++;
                p5++;
                i++;
                continue;
            }

            while (i <= n && p3 * 3 <= i) {
                results.add("fizz");
                p3++;
                i++;
            }

            while (i <= n && p5 * 5 <= i) {
                results.add("buzz");
                p5++;
                i++;
            }
        }

        return results;
    }
}
