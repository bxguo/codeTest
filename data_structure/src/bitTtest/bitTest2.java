package bitTtest;


import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 简单应用
 * Created by bxguo on 2019/4/3 16:58
 */
public class bitTest2 {

    public static void main(String[] args) {
        int x = 1;
        int y = 3;
        System.out.println((x&y)+((x^y)>>1));
//        ReentrantLock.
    }

    private static void getRan() {
        for (int i = 0; i < 10; i++) {
            System.out.println((int) (Math.random() * 10));
        }
    }

    // 位数 2
    static int stringSize(int x) {
        int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
                99999999, 999999999, Integer.MAX_VALUE };
        for (int i=0; ; i++)
            if (x <= sizeTable[i])
                return i+1;
    }

    //位数
    private static void bitNum() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            int k = 0;
            while (i > 0) {
                i = i / 10;
                k++;
            }
            System.out.println(k);
        }
    }
}
