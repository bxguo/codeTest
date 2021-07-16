package leetmeet;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: bxguo
 * @time: 2021/4/16 10:53
 */
public class Meet1 {

    public static void main(String[] args) {
        System.out.println(Meet1.isUnique2("abc"));
    }
    public static boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            set.add(astr.charAt(i));
        }
        if (set.size() == astr.length()) {
            return true;
        }
        return false;
    }
    public static boolean isUnique2(String astr) {
        int[] arr = new int[128];
        for (int a = 0; a < astr.length(); a++) {
            if (arr[astr.charAt(a)] != 0) {
                return false;
            }
            arr[astr.charAt(a)] = 1;
        }
        return true;
    }
}

