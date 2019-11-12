package Leetcode;

//https://leetcode.com/problems/first-missing-positive/

public class FirstMissingPositiveNumber {

    public static void main(String[] args) {
        int arr[] = {3222, 4, -1, 1};
        int result = findMissingNumber(arr);
        System.out.println(result);
    }

    private static int findMissingNumber(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] == i + 1 || A[i] <= 0 || A[i] > A.length) i++;
            else if (A[A[i] - 1] != A[i]) swap(A, i, A[i] - 1);
            else i++;
        }
        i = 0;
        while (i < A.length && A[i] == i + 1) i++;
        return i + 1;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
