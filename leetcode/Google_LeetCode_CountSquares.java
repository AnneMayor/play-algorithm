package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Google_LeetCode_CountSquares {
    public int countSquares(int[][] points) {
        int res = 0;

        int n = points.length;

        Set<String> allPoints = new HashSet<>();
        for (int[] point : points) {
            allPoints.add(convertIntToString(point));
        }

        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1 == p2)
                    continue;

                double midPointX = (p1[0] + p2[0]) / 2.0;
                double midPointY = (p1[1] + p2[1]) / 2.0;

                double xDiff = p1[0] - midPointX;
                double yDiff = p1[1] - midPointY;

                double[] p3 = new double[2], p4 = new double[2];

                p3[0] = midPointX + yDiff;
                p3[1] = midPointY - xDiff;

                p4[0] = midPointX - yDiff;
                p4[1] = midPointY + xDiff;

                if (allPoints.contains(convertDoubleToString(p3)) && allPoints.contains(convertDoubleToString(p4))) {
                    res++;
                }
            }
        }

        return res / 4;
    }

    private String convertIntToString(int[] point) {
        return String.valueOf(point[0] + " : " + point[1]);
    }

    private String convertDoubleToString(double[] point) {
        if (point[0] % 1 == 0 && point[1] % 1 == 0) {
            return (int) point[0] + " : " + (int) point[1];
        }
        return String.valueOf(point[0] + " : " + point[1]);
    }
}
