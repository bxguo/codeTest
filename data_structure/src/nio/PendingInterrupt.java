package nio;

/**
 * 待决中断
 * @author: bxguo
 * @time: 2019/3/18 17:16
 */
public class PendingInterrupt {
    public static void main(String[] args){
        //如果输入了参数，则在mian线程中中断当前线程（亦即main线程）
        if( args.length > 0 ){
            Thread.currentThread().interrupt();
        }
        //获取当前时间
        long startTime = System.currentTimeMillis();
        try{
            Thread.sleep(10000);
            System.out.println("was NOT interrupted");
        }catch(InterruptedException x){
            System.out.println("was interrupted");
        }
        //计算中间代码执行的时间
        System.out.println("elapsedTime=" + ( System.currentTimeMillis() - startTime));
    }
}
