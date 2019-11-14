package cache;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 带过期时间的FIFO，
 * 当容量不足时先淘汰超过过期时间的数据，还抄则淘汰最久依次访问的数据
 *
 * @author: bxguo
 * @time: 2019/11/13 10:11
 */
public class FIFOCache {
    /**
     * 按照访问时间排序,保存所有key-value
     */
    private final Map<String, Value> CACHE = new LinkedHashMap<>();
    /**
     * 过期数据，只保存有过期时间的key
     * 暂不考虑并发，我们认为同一个时间内没有重复的key，如果改造的话，可以将value换成set
     */
    private final TreeMap<Long, String> EXPIRED = new TreeMap<>();

    private final int capacity;

    public FIFOCache(int capacity) {
        this.capacity = capacity;
    }

    public Object get(String key) {
        Value value = CACHE.get(key);
        if (value.expired > 0 && value.expired < System.currentTimeMillis()) {
            EXPIRED.remove(value.expired);
            return null;
        }
        return value.value;
    }

    /**
     * 不设置过期时间默认是-1，永不过期
     */
    public void put(String key, Object value) {
        put(key, value, -1);
    }

    public void put(String key, Object value, int seconds) {
        //if seconds less than 0
        if (seconds < 0 && seconds != -1) {
            put(key, value);
        }

        //suppose key repeat
        Value repeat = CACHE.remove(key);
        if (repeat != null && repeat.expired > 0) {
            EXPIRED.remove(repeat.expired);
        }
        long expired = expiredTime(seconds);
        CACHE.put(key, new Value(expired, value));
        if (expired > 0) {
            EXPIRED.put(expired, key);
        }

        //淘汰过期
        if(capacity < CACHE.size()) {
            Set<Long> k1s = EXPIRED.keySet();
            k1s.forEach(aLong -> {
                if (aLong < System.currentTimeMillis()) {
                    CACHE.remove(EXPIRED.get(aLong));
                    EXPIRED.remove(aLong);
                }
            });
        }

        // 淘汰最久未使用
        Set<Map.Entry<String, Value>> entries = CACHE.entrySet();
        Iterator<Map.Entry<String, Value>> iterator = entries.iterator();
        while (iterator.hasNext() && capacity < CACHE.size()){
            EXPIRED.remove(iterator.next().getValue().expired);
            iterator.remove();
        }
    }

    /**
     * 移除数据如果
     */
    public void remove(String key) {
        Value value = CACHE.remove(key);
        EXPIRED.remove(value.expired);
    }

    private long expiredTime(int expired) {
        return System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(expired);
    }


    private class Value {
        long expired; //过期时间,纳秒
        Object value;

        Value(long expired, Object value) {
            this.expired = expired;
            this.value = value;
        }
    }
}
