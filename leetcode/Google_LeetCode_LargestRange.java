package leetcode;

import java.util.*;

public class Google_LeetCode_LargestRange {
  // public static int[] largestRange(int[] array) {
  //   Arrays.sort(array);

  //   int prev = array[0], next = array[0];

  //   int n = array.length;

  //   int[] res = { prev, next };

  //   for (int idx = 0; idx < n - 1; idx++) {
  //     if (Math.abs(array[idx] - array[idx + 1]) > 1) {
  //       if (next - prev + 1 > res[1] - res[0] + 1) {
  //         res[0] = prev;
  //         res[1] = next;
  //       }
  //       prev = array[idx + 1];
  //     }
      
  //     next = array[idx + 1];
  //   }

  //   if (next - prev + 1 > res[1] - res[0] + 1) {
  //     res[0] = prev;
  //     res[1] = next;
  //   }

  //   return res;
  // }

  public static int[] largestRange(int[] array) {
    Map<Integer, Boolean> tables = new HashMap<>();

    for(int num : array) {
      tables.put(num, false);
    }

    int[] res = {array[0], array[0]};
    int currentRangeLength = 1;
    
    for(int num : array) {
      if(tables.containsKey(num) && tables.getOrDefault(num, true) == false) {
        tables.put(num, true);
        
        int left = num - 1, right = num + 1;
        while(tables.containsKey(left)) {
          if(tables.getOrDefault(left, true) == false) {
            tables.put(left, true);
            left--;
          }
        }

        while(tables.containsKey(right)) {
          if(tables.getOrDefault(right, true) == false) {
            tables.put(right, true);
            right++;
          }
        }

        if(currentRangeLength < (right - 1) - (left + 1) + 1) {
          res[0] = left + 1;
          res[1] = right - 1;
          currentRangeLength = (right - 1) - (left + 1) + 1;
        }

      }
    }

    return res;
  }
}
