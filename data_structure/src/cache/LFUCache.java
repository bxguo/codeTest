package cache;

import java.util.*;

/**
 * @author: bxguo
 * @time: 2019/11/13 11:59
 */
public class LFUCache {
    //主要容器，用于保存k-v
    private Map<String, Object> keyToValue = new HashMap<>();

    //记录每个k被访问的次数
    private Map<String, Integer> keyToCount = new HashMap<>();

    //访问相同次数的key列表，按照访问次数排序，value为相同访问次数到key列表。
    private TreeMap<Integer, LinkedHashSet<String>> countToLRUKeys = new TreeMap<>();

    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        //初始化，默认访问1次，主要是解决下文
    }

    public Object get(String key) {
        if (!keyToValue.containsKey(key)) {
            return null;
        }

        touch(key);
        return keyToValue.get(key);
    }

    /**
     * 如果一个key被访问，应该将其访问次数调整。
     * @param key
     */
    private void touch(String key) {
        int count = keyToCount.get(key);
        //访问次数增加
        keyToCount.put(key, count + 1);
        //从原有访问次数统计列表中移除
        countToLRUKeys.get(count).remove(key);

        //如果符合最少调用次数到key统计列表为空，则移除此调用次数到统计
        if (countToLRUKeys.get(count).size() == 0) {
            countToLRUKeys.remove(count);
        }

        //然后将此key的统计信息加入到管理列表中
        LinkedHashSet<String> countKeys = countToLRUKeys.get(count + 1);
        if (countKeys == null) {
            countKeys = new LinkedHashSet<>();
            countToLRUKeys.put(count + 1,countKeys);
        }
        countKeys.add(key);
    }

    public void put(String key, Object value) {
        if (capacity <= 0) {
            return;
        }

        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            touch(key);
            return;
        }
        //容量超额之后，移除访问次数最少的元素
        if (keyToValue.size() >= capacity) {
            Map.Entry<Integer, LinkedHashSet<String>> entry = countToLRUKeys.firstEntry();
            Iterator<String> it = entry.getValue().iterator();
            String evictKey = it.next();
            it.remove();
            if (!it.hasNext()) {
                countToLRUKeys.remove(entry.getKey());
            }
            keyToCount.remove(evictKey);
            keyToValue.remove(evictKey);

        }

        keyToValue.put(key, value);
        keyToCount.put(key, 1);
        LinkedHashSet<String> keys = countToLRUKeys.get(1);
        if (keys == null) {
            keys = new LinkedHashSet<>();
            countToLRUKeys.put(1,keys);
        }
        keys.add(key);
    }

}
