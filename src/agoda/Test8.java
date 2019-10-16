package agoda;

public class Test8 {
    public static void main(String[] args) {
        int n=3;
        long result=getResult(n);
        System.out.println(result);
    }

    private static long getResult(int n) {
        long m=n*(n-1);
        int sum=0;
        int a=1;
        int d=2;
        for(int i=0;i<n;i++){
            sum = sum + a;
            a = a + d;
        }
        return m*n+sum;
    }
}
