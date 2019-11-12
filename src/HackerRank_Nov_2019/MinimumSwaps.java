package HackerRank_Nov_2019;


//https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
public class MinimumSwaps {

    public static void main(String[] args) {
        //int[] arr = {1, 3, 5, 2, 4, 6, 7};
        //int[] arr = {7, 1, 3, 2, 4, 5, 6};
        int[] arr = {4,3,1,2};
        int result = minSwap(arr);
        //int result = minSwapNew(arr);
        System.out.println(result);

    }

    private static int minSwap(int[] arr) {
        int count = 0;
       for(int i=0;i<arr.length;i++){
           while(arr[i]!=arr[arr[i]-1]){
               int temp = arr[arr[i] - 1];
               arr[arr[i] - 1] = arr[i];
               arr[i] = temp;
               System.out.println("swaping  "+ (arr[i]-1)+ " and "+ i);
               count++;
           }
       }
       return count;
    }

    private static int minSwapNew(int[] arr){
        int swap = 0;
        for (int i = 0; i < arr.length; i++) {
            while (i+1 != arr[i]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
                System.out.println("swaping  "+ (arr[i]-1)+ " and "+ i);
                swap ++;
            }
        }
        return swap;
    }

    private static void swapNumber(int[] arr, int i, int j) {
        //System.out.println("swaping + "+ arr[i]+ "and "+ arr[j]);
        System.out.println("swaping  "+ i+ " and "+ j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

