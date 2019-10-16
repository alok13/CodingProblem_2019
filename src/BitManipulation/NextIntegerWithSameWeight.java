package BitManipulation;

import java.io.*;

public class NextIntegerWithSameWeight {
    static int getNext(int n) {

        /* Compute c0 and c1 */
        //c1 ==> Number of ones to the right of p
        //c0 ==> Number of zeros to the right of p.
        String nn=Integer.toBinaryString(n);
        int c = n;
        int c0 = 0;
        int c1 = 0;

        while (((c & 1) == 0) &&
                (c != 0)) {
            c0++;
            c >>= 1;
        }
        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }
        // If there is no bigger number with the same no. of 1's
        if (c0 + c1 == 31 || c0 + c1 == 0)
            return -1;

        String c00=Integer.toBinaryString(c0);
        String c01=Integer.toBinaryString(c1);
        // position of rightmost non-trailing zero
        int p = c0 + c1;

        // Flip rightmost non-trailing zero
        n |= (1 << p);
        String n01=Integer.toBinaryString(n);
        // Clear all bits to the right of p
        n &= ~((1 << p) - 1);
        String n02=Integer.toBinaryString(n);
        // Insert (c1-1) ones on the right.
        int ll=(1 << (c1 - 1));
        String ll1=Integer.toBinaryString(ll);
        int  mm=ll-1;
        String mm1=Integer.toBinaryString(mm);
        String n03=Integer.toBinaryString(n);
        n |= mm;

        String n04=Integer.toBinaryString(n);
        return n;
    }


    // Driver Code
    public static void main(String[] args) {

        int n = 5; // input 1
        //System.out.println(getNext(n));
        n = 156; // input 2
        System.out.println(getNext(n));
    }
}

// This code is contributed by aj_36


