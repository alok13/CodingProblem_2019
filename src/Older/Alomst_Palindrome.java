package Older;

public class Alomst_Palindrome {
    public static void main(String[] args) {
        String s="aaabbb";
        String reverse="";
        for(int i = s.length() - 1; i >= 0; i--)
        {
            reverse = reverse + s.charAt(i);
        }
        int count=0;
        for(int i=0;i<s.length();i++){
            if(!String.valueOf(reverse.charAt(i)).equals(String.valueOf(s.charAt(i)))){
                count++;
            }
        }
        System.out.println(count);
    }
}
