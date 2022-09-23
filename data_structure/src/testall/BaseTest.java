package testall;

import cn.hutool.core.util.StrUtil;
import concurrent.SemaphoreDemo01.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bxguo on 2019/9/4 21:17
 */
public class BaseTest {
    public static void main(String[] args) {
        int int1 = 12;
        int int2 = 12;

        Integer integer1 = new Integer(12);
        Integer integer2 = new Integer(12);
        Integer integer3 = new Integer(127);

        Integer a1 = 127; //或者写成Integer a1 = Integer.valueOf(127);
        Integer a2 = 127;//或者写成Integer a2 = Integer.valueOf(127);

        Integer a = 128;
        Integer b = 128;

        System.out.println("int1 == int2 T-> " + (int1 == int2));
        System.out.println("int1 == integer1 T-> " + (int1 == integer1));
        System.out.println("int1 == integer2 T-> " + (int1 == integer2));
        System.out.println("integer1 == integer2 F-> " + (integer1 == integer2));
        System.out.println("integer3 == a1 -> F" + (integer3 == a1));
        System.out.println("a1 == a2 -> T" + (a1 == a2));
        System.out.println("a == b -> F" + (a == b));

        int maxValue = Integer.MAX_VALUE;
        System.out.println(maxValue);

        User user = new User(1,"a");
        User user1 = new User(1,"a");
        User user2 = new User(2,"b");
        User user3 = new User(1,"a");
        List<User> users = Arrays.asList(user, user1, user2, user3);
        String join = StrUtil.join(",", users.stream().map(User::getName).collect(Collectors.toList()));
        System.out.println(join);


    }
}
