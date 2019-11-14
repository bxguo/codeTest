package concurrent2.ifwhile;

/**
 * @author: bxguo
 * @time: 2019/10/21 14:26
 */
class Consumer implements Runnable {
    private SynStack ss = null;

    public Consumer(SynStack ss)
    {
        this.ss = ss;
    }

    @Override
    public void run()
    {
        for (int i=0; i<10; ++i)
        {
            /*try{
            Thread.sleep(100);
            }
            catch (Exception e){
            }*/

            //System.out.printf("%c\n", ss.pop());
            ss.pop();
        }
    }
}
