package Leetcode;

import java.util.LinkedList;

public class Course_Schedule_II {
    public static void main(String[] args) {


        //int n = 4;
        int n = 2;
        //int[][] arr = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] arr = {{1, 0}};
        int[] result = findOrder(n, arr);
        for(int i=0;i<result.length;i++)
        System.out.println(result[i]);
    }



    private static int[] findOrder(int n, int[][] arr) {
        if (arr == null)
        return null;

        if (arr.length == 0) {
            int result[] = new int[n];
            for (int i = 0; i < result.length; i++) {
                result[i] = i;
            }
            return result;
        }
        int counter[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int b=arr[i][0];
            counter[b]=counter[b]+1;
        }


        LinkedList<Integer> queue = new LinkedList();
        for (int i = 0; i < n; i++) {
            if (counter[i] == 0)
                queue.add(i);
        }
        int num_Of_Courses = queue.size();

        int result[] = new int[n];
        int j = 0;

        while (!queue.isEmpty()) {
            int c = queue.remove();
            result[j] = c;
            j++;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i][1] == c) {
                    counter[arr[i][0]]--;
                    if (counter[arr[i][0]] == 0) {
                        queue.add(arr[i][0]);
                        num_Of_Courses++;
                    }
                }
            }
        }

        if (num_Of_Courses == n)
            return result;
        else
            return new int[0];
    }
}
