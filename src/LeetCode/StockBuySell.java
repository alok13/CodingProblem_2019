package LeetCode;

public class StockBuySell {
    public static void main(String[] args) {
        int[] arr={7,6,4,3,1};
        int result=findMaxDiff(arr);
        System.out.println(result);
    }

    private static int findMaxDiff(int[] arr) {
        int maxDiff=arr[1]-arr[0];
        int min_Num=arr[0];
        for(int i=1;i<arr.length;i++){
            if(maxDiff<arr[i]-min_Num)
                maxDiff=arr[i]-min_Num;
            if(arr[i]<min_Num)
                min_Num=arr[i];
        }
          return (maxDiff<0) ? 0:maxDiff;
    }
}
