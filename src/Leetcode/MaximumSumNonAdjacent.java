package Leetcode;

public class MaximumSumNonAdjacent {

    public static void main(String[] args) {
        int [] arr={5, 5, 10, 100, 10, 5};
        int result=findSum(arr);
        System.out.println(result);
    }

    private static int findSum(int[] arr) {
        int incl=arr[0];
        int exl=0;
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];
            int exclude_new=incl;
            incl=Math.max(exl+curr,incl);
            exl=exclude_new;
        }
        return incl;
    }
}
