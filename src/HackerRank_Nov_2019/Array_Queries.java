package HackerRank_Nov_2019;

//https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
public class Array_Queries {
    public static void main(String[] args) {
        int n = 4;
//        int arr[][] = {
//                {1, 2, 100},
//                {2, 5, 100},
//                {3, 4, 100}
//
//        };
//        int arr[][] = {
//                { 2, 6 ,8},
//                {3 ,5 ,7},
//                {1, 8, 1},
//                {5, 9, 15}
//        };

        int arr[][] = {
                {2, 3, 603},
                {1, 1, 286},
                {4, 4, 882}

        };


        long result = solve(n, arr);
        System.out.println(result);
    }

    private static long solve(int n, int[][] arr) {
        long resultArray[] = new long[n];

        for (int i = 0; i < arr.length; i++) {
            int p=arr[i][0];
            int q=arr[i][1];
            resultArray[p-1] = resultArray[p-1]+arr[i][2];
            if (arr[i][1] < n)
                resultArray[q] = resultArray[q]-arr[i][2];
        }
        long max = 0;
        long result = 0;
        for (int i = 0; i < n; i++) {
            result = result + resultArray[i];
            if (result > max)
                max = result;
        }
        return max;
    }

}
