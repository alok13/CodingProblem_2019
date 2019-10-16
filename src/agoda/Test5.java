package agoda;

import java.util.ArrayList;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(791);
        list.add(574);
        list.add(85);
        list.add(748);
        int result=MatrixChainOrder(list);
    }
    static int MatrixChainOrder(List<Integer> list)
    {
       int r=list.get(0);
       for(int i=1;i<list.size();i++){
           r=r&list.get(i);
    }
        return r;
//        /* For simplicity of the program, one extra row and one
//        extra column are allocated in m[][].  0th row and 0th
//        column of m[][] are not used */
//        int n=list.size();
//        int m[][] = new int[n][n];
//
//        int i, j, k, L, q;
//
//        /* m[i,j] = Minimum number of scalar multiplications needed
//        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
//        dimension of A[i] is p[i-1] x p[i] */
//
//        // cost is zero when multiplying one matrix.
//        for (i = 1; i < n; i++)
//            m[i][i] = 0;
//
//        // L is chain length.
//        for (L=2; L<n; L++)
//        {
//            for (i=1; i<n-L+1; i++)
//            {
//                j = i+L-1;
//                if(j == n) continue;
//                m[i][j] = Integer.MAX_VALUE;
//                for (k=i; k<=j-1; k++)
//                {
//                    // q = cost/scalar multiplications
//                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
//                    if (q < m[i][j])
//                        m[i][j] = q;
//                }
//            }
//        }
//
//        return m[1][n-1];
    }
}
