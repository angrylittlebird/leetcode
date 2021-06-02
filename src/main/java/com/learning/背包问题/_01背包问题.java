package com.learning.背包问题;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @Author: ZHANG
 * @Date: 2021/6/2
 * @Description: 当背包的最大容量为W，最大可装个数为N的情况下， 可装入的最大价值是多少？
 */
public class _01背包问题 {
    public static int maxValue(int[] val, int[] wt, int N, int W) {
        assertTrue(val.length == N && wt.length == N);

        int[][] dp = new int[N + 1][W + 1];
        //容量为w的限制下，前i个（包含i）元素里可放入的最大价值
        //base case: dp[0][..] = 0; dp[..][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w < wt[i - 1]) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], val[i - 1] + dp[i - 1][w - wt[i - 1]]);
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
//        int[] val = {1};
//        int[] wt = {2};
//        int value = maxValue(val, wt, 1, 3);
//        assertEquals(1, value);

        int[] val = {1, 2};
        int[] wt = {1, 1};
        int value = maxValue(val, wt, 2, 1);
        assertEquals(2, value);
    }
}
