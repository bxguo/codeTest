package leetcode.search;

/**
 * @author: bxguo
 * @time: 2019/8/20 15:55
 */
public class BoyerMoore {
    public static void getRight(String pat, int[] right) {
        for (int i = 0; i < 256; i++){
            right[i] = -1;
        }
        for (int i = 0; i < pat.length(); i++) {
            right[pat.charAt(i)] = i;
        }
    }

    public static int BoyerMooreSearch(String txt, String pat, int[] right) {
        int M = txt.length();
        int N = pat.length();
        int skip;
        for (int i = 0; i <= M - N; i += skip) {
            skip = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1){
                        skip = 1;
                    }
                    break;
                }
            }
            if (skip == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String txt = "BBC ABCDAB AACDABABCDABCDABDE";
        String pat = "ABCDABD";
        int[] right = new int[256];
        getRight(pat,right);
        System.out.println(BoyerMooreSearch(txt, pat, right));
    }

}
