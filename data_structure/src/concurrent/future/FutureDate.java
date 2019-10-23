package concurrent.future;

/**
 * Created by bxguo on 2019/10/23 15:23
 */
public class FutureDate implements Date {
    private  RealDate realDate;
    private  boolean ready = false;


    public FutureDate() {
       super();
    }

    @Override
    public synchronized String getContent() {
        while (!ready){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String content = this.realDate.getContent();
        ready = false;
        notifyAll();
        return content;
    }
    public synchronized void putContent(RealDate realDate) {
        while (ready){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.realDate = realDate;
        this.ready = true;
        notifyAll();
    }
}
