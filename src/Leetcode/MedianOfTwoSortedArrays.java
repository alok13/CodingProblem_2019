package Leetcode;

//https://medium.com/@dimko1/median-of-two-sorted-arrays-b7f0c4284159
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        int a[] = {900};
        int b[] = { 10,13,14};
        System.out.println(findMedian(a,b));
    }

    public static int findMedian(int a[], int b[]) {
        int min_index = 0;
        int max_index = a.length;
        int n = a.length;
        int m = b.length;
        int median = 0;
        int i = 0;
        int j = 0;

        while (min_index <= max_index) {
            i = (min_index + max_index) / 2;
            j = ((n + m + 1) / 2) - i;

            if (i < n && j > 0 && b[j - 1] > a[i])  {
                min_index = i + 1;
            } else if (i > 0 && j < m && b[j] < a[i - 1])  {
                min_index = i - 1;
            } else {
                if (i == 0)
                    median = b[j - 1];
                else if (j == 0)
                    median = a[i-1];
                else
                    median = Math.max(a[i - 1], b[j - 1]);
                break;
            }
        }

        if ((n + m ) / 2 == 1)
            return median;


        if (i == n)
            return (median + b[j]) / 2;


        if (j == m)
            return (median + a[i]) / 2;

        return (median + Math.min(a[i], b[j])) / 2;
    }
}
