package concurrent.future;

/**
 * Created by bxguo on 2019/10/23 15:23
 */
public class RealDate implements Date {
    private final String content;

    public RealDate(int count, String c) {
        this.content = c+"";
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getContent() {
        return this.content;
    }
}
