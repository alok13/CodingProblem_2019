package Leetcode;
//https://www.youtube.com/watch?v=0xeBqanD5GQ

//Time :O(n2)
//Space : O (n2)
public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        String s="alokkolass";
        String result=getLongestPalindrome(s);
        System.out.println(result);
    }

    private static String getLongestPalindrome(String s) {
    int length=s.length();
    boolean [][] isPalindrome=new boolean[length][length];

    int right=0;
    int left=0;

    for(int i=1;i<length;i++){
        for(int j=0;j<i;j++){
            boolean isInnerWordPalindrome=isPalindrome[j+1][i-1]  || i-j<=2;
            if(s.charAt(i)==s.charAt(j) && isInnerWordPalindrome){
                isPalindrome[j][i]=true;

                if(i-j>right-left){
                    right=i;
                    left=j;
                }
            }
        }
    }
    return s.substring(left,right+1);
    }


}
