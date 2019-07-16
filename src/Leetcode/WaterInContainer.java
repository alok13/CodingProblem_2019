package Leetcode;

public class WaterInContainer {
    public static void main(String[] args) {
        int[] arr={1,8,6,2,5,4,8,3,7};
        int value=findWaterInContainer(arr);
        System.out.println(value);
    }


    private static int findWaterInContainer(int[] arr) {
        int n1=0;
        int n2=arr.length-1;
        int prod=0;
        while(n1<n2){
            int height=Math.min(arr[n1],arr[n2]);
            int current_prod=height*(n2-n1);
            if(prod<current_prod)
                prod=current_prod;
            if(arr[n1]<arr[n2])
                n1++;
            else
                n2--;
        }
        return prod;
    }
}
