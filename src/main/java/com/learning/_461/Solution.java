package com.learning._461;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @Author: ZHANG
 * @Date: 2021/6/4
 * @Description:
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length][target + 1];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (j == nums[i]) {
                    dp[i][j] = true;
                    continue;
                }

                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean partition = solution.canPartition(new int[]{1, 1});
        Assert.assertTrue(partition);

        partition = solution.canPartition(new int[]{1, 2});
        Assert.assertFalse(partition);

        partition = solution.canPartition(new int[]{1, 2, 3});
        Assert.assertTrue(partition);

        partition = solution.canPartition(new int[]{6, 1, 2, 3});
        Assert.assertTrue(partition);

        partition = solution.canPartition(new int[]{100});
        Assert.assertFalse(partition);
    }
}
