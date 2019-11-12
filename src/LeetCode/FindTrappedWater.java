package Leetcode;
//https://leetcode.com/problems/trapping-rain-water/

public class FindTrappedWater {
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = finaWater(arr);
        System.out.println(result);

    }


    private static int finaWater(int[] arr) {
        int leftMax = 0;
        int rightMax = 0;
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > leftMax)
                leftMax = arr[i];
            left[i] = leftMax;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > rightMax)
                rightMax = arr[i];
            right[i] = rightMax;
        }
        int result=0;
        for(int i=0;i<arr.length;i++){
            result=result+(Math.min(left[i],right[i])-arr[i]);
        }
        return result;
    }
}
