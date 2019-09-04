package leetcode.search;

/**
 * 暴力匹配
 * @author: bxguo
 * @time: 2019/8/20 15:53
 */
public class ForceSearch {
    public static int forceSearch(String txt, String pat) {
        int M = txt.length();
        int N = pat.length();
        for (int i = 0; i <= M - N; i++) {
            int j = 0;
            /*for (j = 0; j < N; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }*/
            while (j < N && txt.charAt(i + j) == pat.charAt(j)) {
                j++;
            }
            if (j == N) {
                return i;
            }
        }
        return -1;
    }

}
