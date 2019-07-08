package concurrent2.future;

import java.util.Arrays;

/**
 * @author: bxguo
 * @time: 2019/7/8 16:22
 */
public class RealData implements Data {

    private String Content;

    public RealData(String str) {
        String[] arr = new String[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str;
        }
        try {
            System.out.println("工作等待中。。。。。");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.Content = Arrays.toString(arr);
        System.out.println("工作完成");
    }


    @Override
    public String getContent() {
        return Content;
    }
}
