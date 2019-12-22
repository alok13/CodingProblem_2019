package Older;

import java.util.HashSet;
import java.util.Set;

public class StringEqual {
    public static void main(String[] args) {
        int[] i = {};
        String s = "test";
        String t = "test";
        //solution()
    }

    public String solution(String S, String T) {
        if (Math.abs(S.length() - T.length()) > 1)
            return "IMPOSSIBLE";
        if (S.equals(T))
            return "EQUAL";
        int len_1 = S.length();
        int len_2 = T.length();
        int small=0;
        int large=0;
        if(len_1>len_2){
            small=len_2;
            large=len_1;
        }else if(len_2>len_1){
            small=len_2;
            large=len_1;
        }


        if(len_1==len_2){
            Set<Character> char_set = new HashSet<>();
            int diff = 0;
            for (int i = 0; i < len_1; i++) {
                if (!Character.toString(S.charAt(i)).equals(Character.toString(S.charAt(i)))) {
                    diff++;
                }
            }
            if(diff==1)
                return "REPLACE";
            else if(diff==2)
                return "SWAP";
            else
                return "IMPOSSIBLE";
        }



        return null;
    }
}
