package Leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String [] arr={"flower","flow","flight"};
        String result=getPrefix(arr);
        System.out.println(result);
    }


    private static String getPrefix(String[] arr) {
        String result="";
        if(arr.length==0)
            return result;
        int n=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(n>arr[i].length())
                n=arr[i].length();
        }

        boolean match=true;
        for(int i=0;i<n;i++){
            char a= arr[0].charAt(i);
            for(int j=1;j<arr.length;j++){
               if(arr[j].charAt(i)!=a){
                   match=false;
                   break;

               }
            }
            if(match)
                result=result+String.valueOf(a);
        }
        return result;
    }
}
