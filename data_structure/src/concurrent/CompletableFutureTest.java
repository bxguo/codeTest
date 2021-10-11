package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 郭炳侠
 * @date 2021/9/22
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture<String> first = CompletableFuture.completedFuture("hello world");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> future = CompletableFuture
                //第二个异步任务
                .supplyAsync(() -> "hello siting", executor)
                // () -> System.out.println("OK") 是第三个任务
                .runAfterBothAsync(first, () -> System.out.println("OK"), executor);
        executor.shutdown();
        future.join();
    }
}
