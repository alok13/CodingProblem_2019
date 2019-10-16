package agoda;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(solve(3,4));
    }


    public static int solve(int M, int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;

        for (int i = M; i <= n; i++)
            res[i] = res[i - 1] + res[i - 2]
                    + res[i - 3];

        return res[n];

    }

}
