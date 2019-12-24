import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumConcat {
    public static void main(String[] args) {
        String[][] arr = {{"1", "0", "1", "1", "1"},
                {"1", "0", "1", "1", "1"},
                {"1", "1", "1", "1", "1"}};
             //   {"0", "0", "0", "1", "1"}};
//        10111
//        10111
//        11111
        int result=maximalRectangle(arr);
        System.out.println(result);

    }

    public static  int maximalRectangle(String[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] height = new int[m][n + 1];

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == "0") {
                    height[i][j] = 0;
                } else {
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int area = maxAreaInHist(height[i]);
            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }

    private static int maxAreaInHist(int[] height) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int max = 0;

        while (i < height.length) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                max = Math.max(max, height[t]
                        * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }

        return max;
    }


}
