package leetcode;

public class Google_LeetCode_LongestSubarrayWithSum {
    public int[] longestSubarrayWithSum(int[] array, int targetSum) {
        int currentSum = 0;
        int startIdx = 0, endIdx = 0;
        int resStartIdx = -1, resEndIdx = -1;
        int n = array.length;

        if(n == 1) {
            if(array[0] == targetSum) {
                return new int[] {0, 0};
            } else {
                return new int[] {};
            }
        }

        while(startIdx < n && endIdx < n) {
            currentSum += array[endIdx];

            if(currentSum > targetSum) {
                currentSum -= array[startIdx];
                if(startIdx == endIdx) {
                    startIdx++;
                    endIdx++;
                } else {
                    startIdx++;
                }
                currentSum -= array[endIdx];
            } else if(currentSum == targetSum) {
                if(resEndIdx - resStartIdx + 1 < endIdx - startIdx + 1) {
                    resStartIdx = startIdx;
                    resEndIdx = endIdx;
                }

                endIdx++;
            } else if(currentSum < targetSum) {
                endIdx++;
            }
        }

        if(resStartIdx < 0 && resEndIdx < 0) {
          return new int[] {};
        }

        return new int[] {resStartIdx, resEndIdx};
    }
}
