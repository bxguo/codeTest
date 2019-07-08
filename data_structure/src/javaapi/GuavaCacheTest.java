package javaapi;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;

/**
 * @author: bxguo
 * @time: 2019/4/23 13:57
 */
public class GuavaCacheTest {
    public static void main(String[] args) {
        LoadingCache<Object, Object> cache = CacheBuilder.newBuilder().softValues().build(new CacheLoader<Object, Object>() {
            @Override
            public Object load(Object o) throws Exception {
                return "hello world";
            }
        });
        try {
            cache.get("asd");
        } catch (ExecutionException e) {


        }
    }
}
