package agoda;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(maxPrimefactorNum(654311332));
    }

    static int[] primeFactor = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53 };

    static int maxPrimefactorNum(int N)
    {
        long[] pri = new long[16];
        pri[0] = primeFactor[0];
        for (int i = 1; i < 16; i++) {
            pri[i] = pri[i - 1] * primeFactor[i];
        }

        int counter = 0;
        while (N >= pri[counter] && counter!=15)
            counter++;
        return counter;
    }
}
