package lintcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 设计一个算法，找出只含素因子2，3，5 的第 n 小的数。
 * @author: bxguo
 * @time: 2019/7/23 17:57
 */
public class Solution4 {
    public int nthUglyNumber(int n) {
        // Write your code here
        Queue<Long> Q = new PriorityQueue<Long>();
        HashSet<Long> inQ = new HashSet<Long>();
        Long[] primes = new Long[3];
        primes[0] = 2L;
        primes[1] = 3L;
        primes[2] = 5L;
        for (int i = 0; i < 3; i++) {
            Q.add(primes[i]);
            inQ.add(primes[i]);
        }
        Long number = 1L;
        for (int i = 1; i < n; i++) {
            number = Q.poll();
            for (int j = 0; j < 3; j++) {
                if (!inQ.contains(primes[j] * number)) {
                    Q.add(number * primes[j]);
                    inQ.add(number * primes[j]);
                }
            }
        }
        return number.intValue();
    }
}
