package codingtest;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int startIndex = 0, endIndex = sortedArray.length - 1;

        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            int value = sortedArray[midIndex];

            if (value < lessThan) {
                startIndex = midIndex + 1;
            } else if (value > lessThan) {
                endIndex = midIndex - 1;
            } else {
                return midIndex;
            }
        }

        return sortedArray[startIndex - 1] == lessThan? startIndex - 1 : startIndex;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 10));
    }
}