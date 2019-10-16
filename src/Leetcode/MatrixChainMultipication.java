package Leetcode;

public class MatrixChainMultipication {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 30};
        findMultipicationCost(arr);
    }

    private static void findMultipicationCost(int[] arr) {
//        int a[][] = new int[arr.length][arr.length];
//        int n = arr.length;
//        for (int i = 1; i < arr.length; i++) {
//            a[i][i] = 0;
//        }
//        for (int L = 2; L < n; L++) {
//            for (int i = 1; i < n - L + 1; i++) {
//                int j = i + L - 1;
//                if (j == n) continue;
//                m[i][j] = Integer.MAX_VALUE;
//                for (int k = i; k <= j - 1; k++) {
//                    // q = cost/scalar multiplications
//                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
//                    if (q < m[i][j])
//                        m[i][j] = q;
//                }
//            }
//        }
//        return m[1][n - 1];
//    }
    }
}
