package structure.VisitorPattern;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.RandomUtil;

/**
 * Created by 郭炳侠 on 2021/1/4.
 */
public class App {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Console.log(RandomUtil.randomString(RandomUtil.BASE_CHAR_NUMBER + RandomUtil.BASE_CHAR.toUpperCase(), 7));
        }
    }

}
