package Leetcode;

public class Ispalindrome {
    public static void main(String[] args) {
        String s="Deleveled";
        boolean result=isP(s);
        System.out.println(result);
    }

    private static boolean isP(String word) {
        if(word==null)
            return false;
        String smallWord=word.toLowerCase();
        int last=word.length()-1;
        int first=0;
        while(first!=last){
            if (smallWord.charAt(first) != smallWord.charAt(last)) {
                return false;
            }
            ++first;
            --last;
        }
        return true;
    }
}
