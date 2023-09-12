package leetcode;

public class Google_LeetCode_MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        int monotonicDirection = -1; // 0: decreasing, 1: increasing

        if(nums[0] > nums[1]) monotonicDirection = 0;
        if(nums[0] < nums[1]) monotonicDirection = 1;
        
        for(int index = 1; index < nums.length - 1; index++) {
            int currentDirection = -1;
            if(nums[index] < nums[index + 1]) currentDirection = 1;
            if(nums[index] > nums[index + 1]) currentDirection = 0;

            if(currentDirection  == -1 || monotonicDirection == -1) continue;

            if(currentDirection != monotonicDirection) return false;
        }

        return true;
    }
}
