package leetcode;

public class Google_LeetCode_MonotoneIncreasingDigit {
    public int monotoneIncreasingDigits(int n) {
        int position = -1;
        int digitsInTheNextPosition = -1;
        while((position = getPositionIndex(n)) >= 0) {
            digitsInTheNextPosition = (int) (n / Math.pow(10, position - 1)) % 10;
            n -= Math.pow(10, position - 1) * (digitsInTheNextPosition + 1);
            n -= n % Math.pow(10, position);
            n += Math.pow(10, position) - 1;
        }

        return n;
    }

    public int getPositionIndex(int n) {
        int position = 0;
        int mod = 10;
        int remain = mod;

        while(n > 0) {
            if(remain < n % mod) {
                return position;
            }
            remain = n % mod;
            n /= mod;
            position++;
        }

        return -1;
    }
}
