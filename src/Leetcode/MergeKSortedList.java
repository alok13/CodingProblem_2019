package Leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 5};
        int arr2[] = {1, 3, 7, 8};
        int[] result = mergeTwoArray(arr, arr2);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);

        // Merged 2 arrays. Now it can be extended to multiple arrays. Now treat array of list as array only and merge them using 2 pointers
    }

    private static int[] mergeTwoArray(int[] arr, int[] arr2) {
        PriorityQueue<Integer> result = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            result.add(arr[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            result.add(arr2[i]);
        }
        int[] finalArray = new int[arr.length + arr2.length];
        int j = 0;
        while (!result.isEmpty()) {
            finalArray[j++] = result.remove();
        }
        return finalArray;
    }
}
