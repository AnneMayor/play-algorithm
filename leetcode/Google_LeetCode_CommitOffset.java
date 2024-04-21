package leetcode;


import java.util.HashMap;
import java.util.Map;

public class Google_LeetCode_CommitOffset {
    public static int[] commitOffsets(int[] offsets) {
        Map<Integer, Integer> map = new HashMap<>();

        int size = offsets.length;
        int[] result = new int[size];

        for(int i = 0; i < size; i++) {
            int offset = offsets[i];
            map.put(offset, offset);
            int lowest = offset;
            int highest = offset;

            if(map.containsKey(offset - 1)) {
                lowest = map.get(offset - 1);
            }

            if(map.containsKey(offset + 1)) {
                highest = map.get(offset + 1);
            }

            map.put(lowest, highest);
            map.put(highest, lowest);

            result[i] = lowest == 0 ? highest : -1;
        }
        
        return result;
    }
    
    public static void main(String... args) {
        int[] sample = {2, 1, 5, 0, 4, 3, 9, 7};

        int[] result = commitOffsets(sample);

        for(int number : result) {
            System.out.println(number + " ");
        }
    }
}
