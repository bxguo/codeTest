package testall;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author 郭炳侠
 * @date 2021/9/16
 */
public class HuCacheTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        LoadingCache<String, Object> caches = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build(new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String key) throws Exception {
                        return 1;
                    }
                });
        try {
            System.out.println(caches.get("key-zorro"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
