package codingtest;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class WSol2 {
    public String solution(String[] leftArray, String[] rightArray) {
        StringBuilder sb = new StringBuilder();
        Set<String> leftSet = new HashSet<>(Arrays.asList(leftArray));

        for (String right : rightArray) {
            if (leftSet.contains(right)) {
                sb.append(right).append(",");
            }
        }

        String[] sortedResult = sb.toString().split(",");
        Arrays.sort(sortedResult);
        
        sb = new StringBuilder();
        for(String s : sortedResult) {
            sb.append(s).append(",");
        }

        return sb.toString().isEmpty() ? "" : sb.toString().substring(0, sb.length() - 1);
    }
}
