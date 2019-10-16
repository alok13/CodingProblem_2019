package HackerRank;

import java.util.ArrayList;
import java.util.List;

public class Test5_Agoda {
    public static void main(String[] args) {

        List<Integer> queries = new ArrayList<>();
        queries.add(1);
        queries.add(2);
        queries.add(3);
        queries.add(4);
        queries.add(5);
        List<String> result=solve(5, "RED", 2, 3, "GREEN", queries);
        System.out.println();
    }

    static List<String> solve(int N, String initialColor, int left, int right, String color, List<Integer> quires) {
        String status[] = new String[N];
        for (int i = 0; i < N; i++) {
            status[i] = initialColor;
        }

        for (int j = left - 1; j <= right - 1; j++) {
            status[j] = color;
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < quires.size(); i++) {
            result.add(status[quires.get(i) - 1]);
        }
        return result;
    }

    static class PaintingRound {
        int left, right;
        String color;

        PaintingRound(int left, int right, String color) {
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }
}
