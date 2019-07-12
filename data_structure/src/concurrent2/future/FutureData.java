package concurrent2.future;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.concurrent.*;

/**
 * @author: bxguo
 * @time: 2019/7/8 16:22
 */
public class FutureData implements Data {

    private boolean exist = false;

    private RealData realData;


    public synchronized void setRealData(RealData realData) {
        this.realData = realData;
        this.exist = true;
        notifyAll();
    }

    @Override
    public synchronized String getContent() {
        while (!exist) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        return realData.getContent();
    }
}
