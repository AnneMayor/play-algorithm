package leetcode;

import java.util.*;

class Google_LeetCode_MinimumAreaRectangle {
    public int minimumAreaRectangle(int[][] points) {
        int n = points.length;
        Set<String> allPoints = new HashSet<>();
        int res = Integer.MAX_VALUE;
        
        for(int[] point : points) {
            allPoints.add(convertIntToString(point[0], point[1]));
        }

        for (int idx1 = 0; idx1 < n - 1; idx1++) {
            int[] p1 = points[idx1];

            for (int idx2 = idx1 + 1; idx2 < n; idx2++) {
                int[] p2 = points[idx2];

                if(p1[0] == p2[0] || p1[1] == p2[1]) continue;

                if(allPoints.contains(convertIntToString(p1[0], p2[1])) && allPoints.contains(convertIntToString(p2[0], p1[1]))) {
                    int area = Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]);
                    res = Math.min(res, area);
                }

            }
        }
        
        if(res == Integer.MAX_VALUE) res = 0;
        
        return res;
  }

    private String convertIntToString(int i, int j) {
        return String.valueOf(i) + " : " + String.valueOf(j);
    }
}
