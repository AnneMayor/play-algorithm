package leetcode;

public class GoogleLeetCode_RangeSumQuery {

    static class NumArray {

        private int[] treeSums;
        private int treeSumSize;
        private int n;

        public NumArray(int[] nums) {
            int h = (int) Math.ceil(Math.log(nums.length) / Math.log(2));
            n = nums.length;
            treeSumSize = (int) Math.pow(2, h) - 1;
            treeSums = new int[4*n];

            initSegmentTreeSumArray(nums, 0, 0, n - 1);
        }

        public int initSegmentTreeSumArray(int[] nums, int index, int start, int end) {
            if (start == end) {
                treeSums[index] = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                treeSums[index] = initSegmentTreeSumArray(nums, 2*index + 1, start, mid) + initSegmentTreeSumArray(nums, 2*index + 2, mid + 1, end);
            }

            return treeSums[index];
        }
        
        public void update(int index, int val) {
            update(0, 0, n - 1, index, val);
        }

        public int update(int index, int start, int end, int updateIndex, int val) {
            if (start == end && start == updateIndex) {
                treeSums[index] = val;
            } else if (start <= updateIndex && updateIndex <= end) {
                int mid = start + (end - start) / 2;
                treeSums[index] = update(2*index + 1, start, mid, updateIndex, val) + update(2*index + 2, mid + 1, end, updateIndex, val);   
            }

            return treeSums[index];
        }
        
        public int sumRange(int left, int right) {
            return sumRange(0, 0, left, right, n - 1);
        }

        public int sumRange(int index, int start, int left, int right, int end) {
            if (start > right || end < left) {
                return 0;
            }

            if (left <= start && end <= right) {
                return treeSums[index];
            }

            int mid = start + (end - start) / 2;

            return sumRange(2*index + 1, start, left, right, mid) + sumRange(2*index + 2, mid + 1, left, right, end);
        }
    }
    
}
