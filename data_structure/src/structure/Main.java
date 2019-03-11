package structure;

import java.util.Scanner;

/**
 * 兰博和提莫闲聊之后，回归到了他们的正题，约德尔人的未来。
 * 说起约德尔人的未来，黑默丁格曾经提出了一个约德尔测试，将约德尔人的历史的每个阶段都用一个字符表达出来。(包括可写字符,不包括空格。)。
 * 然后将这个字符串转化为一个01串。转化规则是如果这个字符如果是字母或者数字，这个字符变为1,其它变为0。
 * 然后将这个01串和黑默丁格观测星空得到的01串做比较，得到一个相似率。相似率越高,则约德尔的未来越光明。
 * 请问:相似率为多少？
 */
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String history = in.nextLine();
        String star = in.nextLine();
        int same = 0;
        int length = history.length();
        for (int i = 0; i < length; i++) {
            char c = history.charAt(i);
            if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                if (star.charAt(i)=='1') {
                    same++;
                }
            } else {
                if (star.charAt(i)=='0') {
                    same++;
                }
            }
        }
        float out = (float) same*100/(float)length;
        System.out.printf("%.2f%%", out);
    }
}
