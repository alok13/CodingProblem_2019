package agoda;

import java.util.Arrays;

public class Test7 {
    public static void main(String[] args) {
        String s="aaabbb";
        int result=getResult(s);
        System.out.println(result);
    }

    private static int getResult(String s) {
        if(s.length()%2!=0)
            return -1;
        String s1 =s.substring(0,s.length()/2);
        String s2 =s.substring(s.length()/2);
        int count = 0;
        int char_count[] = new int[26];
        for (int i = 0; i < s1.length(); i++)
            char_count[s1.charAt(i) - 'a']++;


        for (int i = 0; i < s2.length(); i++)
            if (char_count[s2.charAt(i) - 'a']-- <= 0)
                count++;

        return count;
    }
}
