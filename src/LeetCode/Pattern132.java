package Leetcode;


import java.util.LinkedList;
//https://leetcode.com/problems/132-pattern/submissions/

//https://leetcode.com/problems/132-pattern/discuss/94071/Single-pass-C++-O(n)-space-and-time-solution-(8-lines)-with-detailed-explanation./220240

public class Pattern132 {
    public static void main(String[] args) {
        int[] test = {3, 1, 4, 2};
        boolean result = doesPatternExists(test);
        System.out.println(result);

    }


    private static boolean doesPatternExists(int[] test) {
        int a2 = Integer.MIN_VALUE;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = test.length-1; i >= 0; i--) {
            int a1 = test[i];
            if (a1 < a2)
                return true;
            else {
                while (!stack.isEmpty() && a1 > stack.peek()) {
                    a2 = stack.pop();
                }
            }
            stack.push(a1);
        }
        return false;
    }
}
