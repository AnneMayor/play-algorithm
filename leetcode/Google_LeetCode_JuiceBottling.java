package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// O(n^2) time | O(n) space
public class Google_LeetCode_JuiceBottling {
    
    public ArrayList<Integer> juiceBottling(int[] prices) {
        Map<Integer, Integer> usedUnitGroup = new HashMap<>();
        int n = prices.length;

        int[] dp = new int[n];

        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= i; j++) {
                if (dp[i-j] + prices[j] > dp[i]) {
                    dp[i] = dp[i-j] + prices[j];
                    usedUnitGroup.put(i, j);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        int currentUnits = n - 1;
        while (usedUnitGroup.containsKey(currentUnits)) {
            result.add(usedUnitGroup.get(currentUnits));
            currentUnits -= usedUnitGroup.get(currentUnits);
        }

        Collections.sort(result);

        return result;
    }
    
}
