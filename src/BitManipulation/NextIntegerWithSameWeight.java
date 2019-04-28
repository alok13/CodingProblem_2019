package BitManipulation;

public class NextIntegerWithSameWeight {
    public static void main(String[] args) {
        int n=156;
        System.out.println(getNext(n));
    }

    static int getNext(int n)
    {
    /* Compute c0
    and c1 */
        int c = n;
        int zeroCount = 0;
        int oneCount
                = 0;
        System.out.println("n : " +Integer.toBinaryString(n));

        while (((c & 1) == 0) && (c != 0))
        {
            zeroCount ++;
            c >>= 1;
        }
        System.out.println("c0 :" +Integer.toBinaryString(zeroCount));
        while ((c & 1) == 1)
        {
            oneCount++;
            c >>= 1;
        }
        System.out.println("c1 :" +Integer.toBinaryString(oneCount));

        // If there is no bigger number
        // with the same no. of 1's
        if (zeroCount + oneCount == 31 || zeroCount + oneCount == 0)
            return -1;
        int c2=(1 << zeroCount);
        System.out.println("c2 : "+Integer.toBinaryString(c2));

        int c3=(1 << (oneCount - 1));

        System.out.println("c3 : " + Integer.toBinaryString(c3));

        int c4=c3-1;
        System.out.println("c4 : "+Integer.toBinaryString(c4));

        int result=n + c2 + c4;

        System.out.println("result :"+ Integer.toBinaryString(result));
        return result;
    }
}






