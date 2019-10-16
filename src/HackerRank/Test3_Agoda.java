package HackerRank;

import java.util.Arrays;

public class Test3_Agoda {
    public static void main(String[] args) {
        String s = "saveChangesInTheEditor";
        int[] arr1 = {4, 1, 2,3,4,10,20,30,40,100,200};
        int k = 10;
        System.out.println(maxMin(k, arr1));
    }

    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int result=Integer.MAX_VALUE;
        for(int i = 0; i < arr.length-k+1; i++){
            result = Math.min(arr[i+k-1] - arr[i], result);
        }
          return result;
    }
//

}
