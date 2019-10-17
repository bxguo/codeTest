package sort;

/**
 * @author: bxguo
 * @time: 2019/10/17 15:01
 */
public class SortUtils {
    protected static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected static boolean less(int v, int w) {
        return v < w;
    }
}
