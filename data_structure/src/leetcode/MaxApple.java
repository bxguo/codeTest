package leetcode;

import java.util.Scanner;

/**
 * 平面上有N＊M个格子，每个格子中放着一定数量的苹果。你从左上角的格子开始，
 * 每一步只能向下走或是向右走，每次走到一个格子上就把格子里的苹果收集起来，这样下去，你最多能收集到多少个苹果？
 *
 * 解决思路：动态规划
 *
 * 1、抽象状态，这个问题的状态很简单，就是走到第i行第j列的格子的时候，收集到的最大苹果数
 * F[i][j]，其中0<=i<=N,0<=j<=M
 *
 * 2、问题转换方程，动态规划的思想就是要求原问题的解就要去子问题的解，这道题的子问题就是，找出能够到达当前格子的所有前一个格子的收集最大苹果数，然后加上当前格子的苹果数即可
 * F[I][j] = A[i][j]+max{if i>0:F[i-1][j] ; if j>0 :F[i][j-1]} //注意这里要考虑，如果第一行和第一列的特殊情况
 *
 * Created by bxguo on 2019/9/15 17:34
 */
public class MaxApple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] A = new int[N][M];
        int[][] F = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = scanner.nextInt();
            }
        }
        F[0][0]=A[0][0];  //初始化第一个格子

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int tempMax = Integer.MIN_VALUE;
                if (i == 0 && j > 0 && F[i][j - 1] + A[i][j] > tempMax)  //第一行的情况
                    tempMax = F[i][j - 1] + A[i][j];
                if (j == 0 && i > 0 && F[i - 1][j] + A[i][j] > tempMax)  //第一列的情况
                    tempMax = F[i - 1][j] + A[i][j];
                if (i > 0 && j > 0 && Math.max(F[i][j - 1] + A[i][j], F[i - 1][j] + A[i][j]) > tempMax)
                    tempMax = Math.max(F[i][j - 1] + A[i][j], F[i - 1][j] + A[i][j]);
                if (i > 0 || j > 0)
                    F[i][j] = tempMax;
            }
        }
        System.out.println(F[N-1][M-1]);
    }

}
