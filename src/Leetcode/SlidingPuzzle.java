package Leetcode;

import java.util.*;

public class SlidingPuzzle {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},
                {4, 0, 5}};
        int result=findMinSteps(arr);
        System.out.println(result);
    }

    private static int findMinSteps(int[][] arr) {
        String target = "123450";
            String s="";
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[0].length;j++){
                    s=s+arr[i][j];
                }
            }
        List<String> swapSet=new ArrayList<>();
        swapSet.add("13");
        swapSet.add("042");
        swapSet.add("15");
        swapSet.add("04");
        swapSet.add("315");
        swapSet.add("42");

        HashSet<String> visited = new HashSet<>();
        Queue<String> queue=new LinkedList();
        int res=0;

        queue.add(s);
        while (!queue.isEmpty()) {
            // level count, has to use size control here, otherwise not needed
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return res;
                }
                int zero = cur.indexOf('0');
                // swap if possible
                for (char dir : swapSet.get(zero).toCharArray()) {
                    String next = swap(cur, zero, dir);
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.offer(next);

                }
            }
            res++;
        }
        return -1;
    }

    private static String swap(String str, int i, char dir) {
        StringBuilder sb = new StringBuilder(str);
        int j=Integer.valueOf(String.valueOf(dir));
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
