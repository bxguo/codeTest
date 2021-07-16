package base;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.PageUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 郭炳侠 on 2020/10/27.
 */
public class CronTest {
    /***
     *  功能描述：日期转换cron表达式
     * @param date
     * @param dateFormat : e.g:yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String formatDateByPattern(Date date, String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }
    /***
     * convert Date to cron ,eg.  "0 07 10 15 1 ? 2016"
     * @param date  : 时间点
     * @return
     */
    public static String getCron(java.util.Date  date){
        String dateFormat="ss mm HH dd MM ? yyyy";
        return formatDateByPattern(date, dateFormat);
    }
    @Test
    public void test_getCron(){
        DateTime dateTime = DateUtil.offsetMinute(new Date(), 1);
        System.out.println(DateUtil.format(dateTime, "yyyy-MM-dd HH:mm:ss"));
        String cron=CronTest.getCron(dateTime);
        System.out.println(cron);
    }
    @Test
    public void test_getCron1() {
        System.out.println(StrUtil.reverse(DateUtil.current(true) + ""));
        System.out.println(StrUtil.reverse(DateUtil.current(true) + ""));
        System.out.println(StrUtil.reverse(DateUtil.current(true) + ""));
        System.out.println(StrUtil.reverse(DateUtil.current(true) + ""));
        System.out.println(StrUtil.reverse(DateUtil.current(true) + ""));

        System.out.println(DateUtil.current(true));


        for (int i = 0; i < 10; i++) {
            int[] ints = PageUtil.transToStartEnd(i - 1, 10);
            System.out.print(ints[0]);
            System.out.print(ints[1]);
            System.out.println();
        }
        System.out.println(DateUtil.beginOfDay(DateUtil.yesterday()));

    }

    @Test
    public void testsub(){
        System.out.println(StrUtil.subAfter("bridge_State_a", "_", false));
    }

}
