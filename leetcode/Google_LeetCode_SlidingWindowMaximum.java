package leetcode;

import java.util.*;

public class Google_LeetCode_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        Deque<Integer> window = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            while (!window.isEmpty() && window.peekFirst() <= i - k) {
                window.pollFirst();
            }

            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }

            window.add(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[window.peekFirst()];
            }
        }

        return res;
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        int[] res = new int[n - k + 1];

        left[0] = nums[0];
        right[n-1] = nums[n-1];

        for(int i = 1; i < n; i++) {
            if (i % k == 0) {
                left[i] = nums[i];
            } else left[i] = Math.max(left[i-1], nums[i]);

            int j = n - i - 1;
            if (j % k == (k - 1)) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }
        
        for(int i = 0, j = i + k - 1; j < n; i++, j++) {
            res[i] = Math.max(right[i], left[j]);
        }

        return res;
    }
}
