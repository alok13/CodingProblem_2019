package BitManipulation;

public class SetBit {
    public static void main(String args[]){
        int n=10;
        int k=2;
        setBitN(n,k);
    }

    private static void setBitN(int n, int k) {
        int m=1<<k;
        System.out.println(n|m);
    }
}
