package LeetCode;

public class StockBuySell2 {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int result = findMaxDiff(arr);
    }

    private static int findMaxDiff(int[] arr) {
        if (arr == null || arr.length < 2)
            return 0;
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

}

class Interval {
    int min;
    int max;
}
