package HackerRank;

public class Test4_Agoda {
    public static void main(String[] args) {
        int arr[] = {3,7,4,6,5};
        System.out.println(maxSubsetSum(arr));
    }

    static int maxSubsetSum(int[] arr) {
       return maxSumSub(arr, 0, arr.length, Integer.MIN_VALUE);

    }

     static int maxSumSub(int[] arr, int i, int n, int record) {

        if (i == n) {
            return 0;
        }
        int withNum = maxSumSub(arr, i + 1, n, record);
        int withoutNum = 0;
        if (record + 1 != i) {
            withoutNum = maxSumSub(arr, i + 1, n, i) + arr[i];
        }
        return Integer.max(withoutNum, withNum);
    }
}
