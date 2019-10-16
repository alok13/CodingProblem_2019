package HackerRank;

//https://www.hackerrank.com/challenges/new-year-chaos
public class NewYearChaos {
    public static void main(String[] args) {
        int[] q = {1, 2, 3, 4, 5};
        int[] q1 = {2, 5, 1, 3, 4};
        int[] q2 = {2, 1, 5, 3, 4};
        int[] q3 = {1, 2, 5, 3, 7, 8, 6, 4};
        minimumBribes(q3);
    }

    static void minimumBribes(int[] q) {
        int count = 0;
        for (int i = 0; i < q.length; i++) {

            if (q[i] - i > 3) {
                System.out.println("Too chaotic");
                return;
            }
            int jj = Math.max(0, q[i] - 2);
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[j] > q[i])
                    count++;
            }
        }
        System.out.println(count);
    }


}
