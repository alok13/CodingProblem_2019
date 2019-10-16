package LeetCode;

public class StockBuySell2Transaction {
    public static void main(String[] args) {
        int[] arr= {100, 30, 15, 10, 8, 25, 80};
        int result=findMaxProfit(arr);
        System.out.println(result);
    }

    private static int findMaxProfit(int[] arr) {
        if(arr==null|| arr.length<2)
            return 0;
       int left[]=new int[arr.length];
       int right[]=new int[arr.length];
        for (int i=0; i<arr.length; i++){
            left[i] = 0;
            right[i] = 0;
        }


        int min=arr[0];
       for(int i=1;i<arr.length;i++){
           min=Math.min(min,arr[i]);
           left[i]=Math.max(left[i-1],arr[i]-min);
       }

       int max=arr[arr.length-1];
        right[arr.length-1]=0;
        for(int i=arr.length-2;i>=0;i--){
            max=Math.max(max,arr[i]);
            right[i]=Math.max(right[i+1],max-arr[i]);
        }

        int profit=0;
        for(int i=0;i<arr.length;i++){
            profit=Math.max(profit,left[i]+right[i]);
        }
        return profit;
    }
}
