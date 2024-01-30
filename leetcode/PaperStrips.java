import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PaperStrips {
    public static int minPieces(int[] original, int[] desired) {
        Map<Integer, Integer> indexValueMap = mappingIndexValue(desired);

        int numOfCuts = 1;
        int prevIndex = indexValueMap.get(original[0]);

        for(int i = 1; i < original.length; i++) {
            int currentIndex = indexValueMap.get(original[i]);

            if (currentIndex == prevIndex + 1) {
                prevIndex++;
            } else {
                prevIndex = currentIndex;
                numOfCuts++;
            }
        }
        return numOfCuts;
    }

    public static Map<Integer, Integer> mappingIndexValue(int[] array) {
        return IntStream.range(0, array.length)
        .boxed()
        .collect(Collectors.toMap(index -> array[index], Function.identity()));
    }

    public static void main(String[] args) {
        int[] original = new int[] { 1, 4, 3, 2 ,5 };
        int[] desired = new int[] { 1, 2, 5, 4, 3 };
        System.out.println(minPieces(original, desired));
    }
}
