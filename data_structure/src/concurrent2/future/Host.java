package concurrent2.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author: bxguo
 * @time: 2019/7/8 16:21
 */
public class Host {
    public Data get(String str) {
        FutureData futureData = new FutureData(() -> new RealData(str));
        new Thread(futureData).start();
        return futureData;
    }
    public Data get2(String str) {
        FutureTask<RealData> realDataFutureTask = new FutureTask<>(() -> new RealData(str));
        new Thread(realDataFutureTask).start();
        RealData realData = null;
        try {
            realData = realDataFutureTask.get();  
            return realData;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return realData;
    }
}
