package concurrent2.ifwhile;

/**
 * @author: bxguo
 * @time: 2019/10/21 14:23
 */
public class SynStack {
    private char[] data = new char[6];
    private int cnt = 0; //表示数组有效元素的个数

    public synchronized void push(char ch)
    {
        if (cnt >= data.length)
        {
            try
            {
                System.out.println("生产线程"+Thread.currentThread().getName()+"准备休眠");
                this.wait();
                System.out.println("生产线程"+Thread.currentThread().getName()+"休眠结束了");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        this.notify();
        data[cnt] = ch;
        ++cnt;
        System.out.printf("生产线程"+Thread.currentThread().getName()+"正在生产第%d个产品，该产品是: %c\n", cnt, ch);
    }

    public synchronized char pop()
    {
        char ch;
        if (cnt <= 0)
        {
            try
            {
                System.out.println("消费线程"+Thread.currentThread().getName()+"准备休眠");
                this.wait();
                System.out.println("消费线程"+Thread.currentThread().getName()+"休眠结束了");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        this.notify();
        ch = data[cnt-1];
        System.out.printf("消费线程"+Thread.currentThread().getName()+"正在消费第%d个产品，该产品是: %c\n", cnt, ch);
        --cnt;
        return ch;
    }
}
