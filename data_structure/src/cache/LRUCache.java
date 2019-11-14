package cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 每次put、get时需要更新key对应的访问时间，
 * 我们需要一个数据结构能够保存key最近的访问时间且能够排序。
 * @author: bxguo
 * @time: 2019/11/13 11:47
 */
public class LRUCache {
    /**
     * 按照访问时间排序,保存所有key-value
     */
    private final Map<String, LRUCache.Value> CACHE = new LinkedHashMap<>();
    /**
     * 过期数据，只保存有过期时间的key
     * 暂不考虑并发，我们认为同一个时间内没有重复的key，如果改造的话，可以将value换成set
     */
    private final TreeMap<Long, String> EXPIRED = new TreeMap<>();

    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public Object get(String key) {
        //
        Value value = CACHE.get(key);
        if (value == null) {
            return null;
        }

        //如果不包含过期时间
        long expired = value.expired;
        long now = System.nanoTime();
        //已过期
        if (expired > 0 && expired <= now) {
            CACHE.remove(key);
            EXPIRED.remove(expired);
            return null;
        }
        //相对于FIFO，增加顺序重置
        CACHE.remove(key);
        CACHE.put(key,value);
        return value.value;
    }

    private class Value {
        long expired; //过期时间,纳秒
        Object value;
        Value(long expired,Object value) {
            this.expired = expired;
            this.value = value;
        }
    }
}
