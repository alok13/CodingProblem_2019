package Leetcode;

public class ReverseNumber {
    public static void main(String[] args) {
        int x=-123;
        int result=reverseNum(x);
        System.out.println(result);
    }

    private static int reverseNum(int x) {

        int n=0;
        while(x>0){
            int i=x%10;
            x=x/10;
            n=n*10+i;
        }
        return n;
    }
}
