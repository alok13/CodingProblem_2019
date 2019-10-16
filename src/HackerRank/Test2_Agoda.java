package HackerRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test2_Agoda {
    public static void main(String[] args) {
        String s = "saveChangesInTheEditor";
        int[] arr = {2, 1, 3};
        int[] arr1 = {7, 8, 9};
        int k = 10;
        System.out.println(twoArrays(k, arr, arr1));
    }

    static String twoArrays(int k, int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < B.length / 2; i++)
        {
            int temp = B[i];
            B[i] = B[B.length - i - 1];
            B[B.length - i - 1] = temp;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] + B[i] < k)
                return "NO";
        }

        return "YES";
    }
}
