package leetcode;

public class Google_LeetCode_FirstDuplicateValue {
  public int firstDuplicateValue(int[] array) {
    long isIncluded = 0L;
    int res = -1;
    for(int number : array) {
      if((isIncluded & (1 << number)) > 0) {
        res = number;
        break;
      }
      isIncluded |= (1 << number);
    }

    return res;
  }

  public int firstDuplicateValue(int[] array) {
    for(int number : array) {
      int absNumber = Math.abs(number);
      if(array[absNumber - 1] < 0) return absNumber;
      array[absNumber - 1] *= -1;
    }

    return -1;
  }
}
