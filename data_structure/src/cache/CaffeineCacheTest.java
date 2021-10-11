package cache;

import com.github.benmanes.caffeine.cache.AsyncCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 郭炳侠
 * @date 2021/9/29
 */
public class CaffeineCacheTest {

    @Test
    public void testCache() throws ExecutionException, InterruptedException{
        AsyncCache<Object, Object> asyncCache = Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .maximumSize(100).executor(Executors.newSingleThreadExecutor()).buildAsync();
        CompletableFuture<Object> future = asyncCache.get(1, integer -> {
            System.out.println("当前所在线程：" + Thread.currentThread().getName());
            return getInDB((int)integer);
        });
        int value  = (int) future.get();
        System.out.println("当前所在线程：" + Thread.currentThread().getName());
        System.out.println(value);
    }
    private int getInDB(int key) {
        return key + 2;
    }

}
