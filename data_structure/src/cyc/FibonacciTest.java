package cyc;

/**
 * @author: bxguo
 * @time: 2019/10/20 14:27
 */
public class FibonacciTest {
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fib = new int[n + 1];
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    public int fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci2(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        FibonacciTest fibonacciTest = new FibonacciTest();
        for (int j = 0; j < 10; j++) {
            System.out.print(fibonacciTest.fibonacci2(j)+",");
        }
        System.out.println("");
        for (int j = 0; j < 10; j++) {
            System.out.print(fibonacciTest.fibonacci(j)+",");
        }
    }
}
