package concurrent2.ifwhile;

/**
 * @author: bxguo
 * @time: 2019/10/21 14:25
 */
public class Producer implements Runnable{
    private SynStack ss = null;
    public Producer(SynStack ss)
    {
        this.ss = ss;
    }

    @Override
    public void run()
    {
        char ch;
        for (int i=0; i<10; ++i)
        {
//            try{
//            Thread.sleep(100);
//            }
//            catch (Exception e){
//            }

            ch = (char)('a'+i);
            ss.push(ch);
        }
    }
}

