package cache;

import com.github.benmanes.caffeine.cache.*;
import leetcode.node.TreeNode;
import org.junit.Test;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
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
    public void testCache() throws ExecutionException, InterruptedException {
        AsyncCache<Object, Object> asyncCache = Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .maximumSize(100).executor(Executors.newSingleThreadExecutor()).buildAsync();
        CompletableFuture<Object> future = asyncCache.get(1, integer -> {
            System.out.println("当前所在线程：" + Thread.currentThread().getName());
            return getInDB((int) integer);
        });
        int value = (int) future.get();
        System.out.println("当前所在线程：" + Thread.currentThread().getName());
        System.out.println(value);
    }

    private int getInDB(int key) {
        return key + 2;
    }

    @Test
    public void testSave() {
        Cache<Object, Object> cache = Caffeine.newBuilder()
                //初始数量
                .initialCapacity(10)
                //最大条数
                .maximumSize(10)
                //PS：expireAfterWrite和expireAfterAccess同时存在时，以expireAfterWrite为准。
                //最后一次写操作后经过指定时间过期
                .expireAfterWrite(1, TimeUnit.SECONDS)
                //最后一次读或写操作后经过指定时间过期
                .expireAfterAccess(1, TimeUnit.SECONDS)
                //监听缓存被移除
                .removalListener((key, val, removalCause) -> {
                })
                //记录命中
                .recordStats()
                .build();

        cache.put("1", "张三");
        System.out.println(cache.getIfPresent("1"));
        System.out.println(cache.get("2", o -> "默认值"));
        System.out.println(cache.get("2", o -> "默认值"));
        System.out.println(cache.stats());
    }

    @Test
    public void testRecord() {
        LoadingCache<String, String> cache = Caffeine.newBuilder()
                //创建缓存或者最近一次更新缓存后经过指定时间间隔，刷新缓存；refreshAfterWrite仅支持LoadingCache
                .refreshAfterWrite(1, TimeUnit.SECONDS)
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .expireAfterAccess(1, TimeUnit.SECONDS)
                .maximumSize(10)
                //开启记录缓存命中率等信息
                .recordStats()
                //根据key查询数据库里面的值
                .build(key -> {
                    Thread.sleep(2000);
                    return new Date().toString();
                });
        cache.put("1", "小明");
        cache.get("1");

        /*
         * hitCount :命中的次数
         * missCount:未命中次数
         * requestCount:请求次数
         * hitRate:命中率
         * missRate:丢失率
         * loadSuccessCount:成功加载新值的次数
         * loadExceptionCount:失败加载新值的次数
         * totalLoadCount:总条数
         * loadExceptionRate:失败加载新值的比率
         * totalLoadTime:全部加载时间
         * evictionCount:丢失的条数
         */
        System.out.println(cache.stats());

    }

    @Test
    public void testAsyncLoadingCache() {
        AsyncLoadingCache<String, String> asyncLoadingCache = Caffeine.newBuilder()
                //创建缓存或者最近一次更新缓存后经过指定时间间隔刷新缓存；仅支持LoadingCache
                .refreshAfterWrite(1, TimeUnit.SECONDS)
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .expireAfterAccess(1, TimeUnit.SECONDS)
                .maximumSize(10)
                //根据key查询数据库里面的值
                .buildAsync(key -> {
                    //Thread.sleep(1000);
                    return new Date().toString();
                });

        //异步缓存返回的是CompletableFuture
        CompletableFuture<String> future = asyncLoadingCache.get("1");
        future.thenAccept(System.out::println);
        Queue<TreeNode> q = new LinkedList<>();
    }

}
