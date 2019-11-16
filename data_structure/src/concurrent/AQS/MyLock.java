package concurrent.AQS;

import com.sun.xml.internal.ws.api.message.Header;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import static sun.misc.VM.getState;

/**
 * Created by bxguo on 2019/11/16 22:21
 */
public class MyLock implements Lock {
    private Helper h = new Helper();

    @Override
    public void lock() {
        h.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        h.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return h.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return h.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        h.tryRelease(1);
    }

    @Override
    public Condition newCondition() {
        return h.newCO();
    }

    private class Helper extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();
            if (state == 0) {
                if (compareAndSetState(0, state + arg)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            } else if (getExclusiveOwnerThread() == Thread.currentThread()) {
                return compareAndSetState(state, state + arg);
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            int state = getState() - arg;
            if (state == 0) {
                setExclusiveOwnerThread(null);
                setState(state);
                return true;
            }
            setState(state);
            return false;
        }

        protected ConditionObject newCO() {
            return new ConditionObject();
        }
    }

}
