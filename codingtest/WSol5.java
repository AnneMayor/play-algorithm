package codingtest;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class WSol5 {

    public int[] solution(int[] card) {
        List<Integer> numList = new ArrayList<>();
        Map<Integer, Integer> cardMap = new HashMap<>();
        for(int cardNumber : card) {
            cardMap.put(cardNumber, cardMap.getOrDefault(cardNumber, 0) + 1);
        }

        cardMap.entrySet().stream().forEach(entry -> {
            if(entry.getValue() == 1) {
                numList.add(entry.getKey());
            }
        });

        numList.sort((a, b) -> a - b);
        
        return numList.stream().mapToInt(i -> i).toArray();
    }
    
}
