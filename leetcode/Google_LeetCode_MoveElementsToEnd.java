package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Google_LeetCode_MoveElementsToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {

        int n = array.size();

        int startIdx = 0, endIdx = n - 1;

        int[] toArray = new int[array.size()];
        for (int idx = 0; idx < n; idx++) {
            toArray[idx] = array.get(idx);
        }

        while (startIdx < endIdx) {
            if (toArray[startIdx] == toMove) {
                while (endIdx > startIdx && toArray[endIdx] == toMove) {
                    endIdx--;
                }
                toArray[startIdx] = toArray[endIdx];
                toArray[endIdx] = toMove;
            }
            startIdx++;
        }

        List<Integer> res = new ArrayList<>();
        for (int number : toArray) {
            res.add(number);
        }

        return res;
    }
}
