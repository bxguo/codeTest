package concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by bxguo on 2019/10/23 15:36
 */
public class Host {
    Date request(int num, String c) {
        FutureTask<RealDate> futureTask = new FutureTask<>(new Callable<RealDate>() {
            @Override
            public RealDate call() throws Exception {
                return new RealDate(num, c);
            }
        });
        new Thread(futureTask).start();
        try {
            return futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

}
