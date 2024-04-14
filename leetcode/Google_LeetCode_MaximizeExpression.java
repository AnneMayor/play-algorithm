package leetcode;

import java.util.Arrays;

public class Google_LeetCode_MaximizeExpression {
  public int maximizeExpression(int[] array) {

    if (array.length < 4) {
      return 0;
    }

    int[][] dp = new int[4][array.length];

    for (int i = 0; i < 4; i++) {
      Arrays.fill(dp[i], Integer.MIN_VALUE);
    }

    int size = array.length;
    dp[0][0] = array[0];

    for (int i = 1; i < size; i++) {
      dp[0][i] = Math.max(dp[0][i - 1], array[i]);
    }

    for (int i = 1; i < size; i++) {
      dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - array[i]);
    }

    for (int i = 2; i < size; i++) {
      dp[2][i] = Math.max(dp[2][i - 1], dp[1][i - 1] + array[i]);
    }

    for (int i = 3; i < size; i++) {
      dp[3][i] = Math.max(dp[3][i - 1], dp[2][i - 1] - array[i]);
    }

    return dp[3][size - 1];
  }
}
