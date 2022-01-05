package cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author 郭炳侠
 * @date 2021/12/29
 */
public class GuavaCahcheTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                //写之后5s过期
                .expireAfterWrite(5, TimeUnit.MILLISECONDS)
                .concurrencyLevel(1)
                .build();
        cache.put("hello1", "我是hello1");
        cache.put("hello2", "我是hello2");
        cache.put("hello3", "我是hello3");
        cache.put("hello4", "我是hello4");
        //至少睡眠5ms
        Thread.sleep(5);
        System.out.println(cache.size());
        //cache.put("hello5", "我是hello5");
        cache.getIfPresent("hello1");

        System.out.println(cache.size());
    }

    public static CacheLoader<String, String> createCacheLoader() {
        return new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return key;
            }
        };
    }
}
