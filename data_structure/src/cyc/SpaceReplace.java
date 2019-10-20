package cyc;

/**
 * 替换空格
 * @author: bxguo
 * @time: 2019/10/20 11:18
 */
public class SpaceReplace {
    public static void main(String[] args) {
        SpaceReplace spaceReplace = new SpaceReplace();
        String s = spaceReplace.replaceSpace(new StringBuffer("a bcdef"));
    }
    public String replaceSpace(StringBuffer str) {
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }

        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }
}
