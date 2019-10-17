package base;

/**
 * @author: bxguo
 * @time: 2019/10/16 11:23
 */
public class BaQuene {
    private static final int MUM = 8;

    public static void main(String[] args) {
        int[][] locate = new int[MUM][MUM];
        BaQuene baQuene = new BaQuene();
        baQuene.fun(locate, 0);
        System.out.println(baQuene);
    }
    void fun(int[][] locate, int y) {
        if (y == MUM) {
            return;
        }
        for (int i = 0; i < MUM; i++) {
            for (int j = 0; j < MUM; j++) {
                locate[j][y] = 0;
            }
            if (check(locate, i, y)){
                locate[i][y] = 1;
                fun(locate, y+1);
            }
        }
    }

    boolean check(int[][] locate, int x, int y) {
        for (int i = 0; i < y; i++) {
            //竖向检查
            if (locate[x][i] == 1) {
                return false;
            }
            //左斜上检查
            //if (locate[y - (y - x)][i] == 1) {
            if (x - 1 - i >= 0 && locate[x - 1 - i][y - 1 - i] == 1) {
                return false;
            }
            //右斜上检查
            //if (locate[y + x - i][i] == 1) {
            if (x + 1 + i < MUM && locate[x + 1 + i][y - 1 - i] == 1) {
                return false;
            }
        }
        return true;
    }
}
