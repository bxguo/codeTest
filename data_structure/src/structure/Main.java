package structure;

import java.util.Scanner;

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
