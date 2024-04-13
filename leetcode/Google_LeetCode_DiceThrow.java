package leetcode;

import java.util.Arrays;

public class Google_LeetCode_DiceThrow {
    // O(numDice * numSides * target) time | O(numDice * target) space
    // public int diceThrows(int numDice, int numSides, int target) {
    //     int[][] dp = new int[numDice + 1][target + 1];
    //     for(int i = 0; i <= numDice; i++) {
    //         Arrays.fill(dp[i], -1);
    //     }

    //     return diceThrowHelper(numDice, numSides, target, dp);
    //   }

    // private int diceThrowHelper(int numDice, int numSides, int target, int[][] result) {
    //     if (numDice == 0) {
    //         return target == 0 ? 1 : 0;
    //     }

    //     if (result[numDice][target] > -1) {
    //         return result[numDice][target];
    //     }

    //     int numOfWays = 0;
    //     for(int currentTarget = Math.max(0, target - numSides); currentTarget < target; currentTarget++) {
    //         numOfWays += diceThrowHelper(numDice - 1, numSides, currentTarget, result);
    //     }

    //     result[numDice][target] = numOfWays;

    //     return numOfWays;
    // }

    // O(numDice * numSides * target) time | O(numDice * target) space
    // public int diceThrows(int numDice, int numSides, int target) {
    //     int[][] result = new int[numDice + 1][target + 1];
    //     result[0][0] = 1;

    //     for(int i = 1; i <= numDice; i++) {
    //         for(int j = 0; j <= target; j++) {
    //             int numOfWays = 0;

    //             for(int k = 1; k <= Math.min(j, numSides); k++) {
    //                 numOfWays += result[i - 1][j - k];
    //             }

    //             result[i][j] = numOfWays;
    //         }
    //     }

    //     return result[numDice][target];
    // }

    // O(numDice * numSides * target) time | O(target) space
    public int diceThrows(int numDice, int numSides, int target) {
        int[][] result = new int[2][target + 1];
        result[0][0] = 1;

        int prevDiceIndex = 0;
        int currentDiceIndex = 1;

        for(int i = 1; i <= numDice; i++) {
            for(int j = 0; j <= target; j++) {
                int numOfWays = 0;
                for(int k = 1; k <= Math.min(j, numSides); k++) {
                    numOfWays += result[prevDiceIndex][j - k];
                }
                result[currentDiceIndex][j] = numOfWays;
            }

            int tempIndex = currentDiceIndex;
            currentDiceIndex = prevDiceIndex;
            prevDiceIndex = tempIndex;
        }

        return result[prevDiceIndex][target];
    }
}
