package hw;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(Main.ReverseWords(s));
    }

    public static String ReverseWords(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            String trim = words[i].trim();
            if (!"".equals(trim)) {
                sb.append(trim).append(" ");
            }
        }
        return sb.toString();
    }
}
