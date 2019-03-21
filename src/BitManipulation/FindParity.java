package BitManipulation;

//Best explainantion :https://stackoverflow.com/a/21618038/11160809
public class FindParity {
    public static void main(String args[]){
        int x=10;
        int isEven=getParity(x);
        System.out.println(isEven);
    }

    private static int getParity(int x) {
        x ^= x >> 16;
        x ^= x >> 8;
        x ^= x >> 4;
        x ^= x >> 2;
        x ^= x >> 1;
        return (~x) & 1;
    }
}
