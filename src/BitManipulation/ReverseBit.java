package BitManipulation;

public class ReverseBit {

    public static void main(String args[]){
        int i=6;
        int pos1=2;
        int pos5=5;
        int result=reverseBits(i);
        System.out.println(result);
        //100
        //001

    }

    public static int reverseBits(int n)
    {
        int rev = 0;

        // traversing bits of 'n'
        // from the right
        while (n > 0)
        {
            // bitwise left shift
            // 'rev' by 1
            rev <<= 1;

            // if current bit is '1'
            int r=(int)(n & 1);
            if ( r== 1)
                rev ^= 1;

            // bitwise right shift
            //'n' by 1
            n >>= 1;
        }
        // required number
        return rev;
    }
}
