package Leetcode;

public class N_Queen {

    public static void main(String[] args) {
        int N = 4;
        int arr[][] = solveNQueen(N);
    }

    private static int[][] solveNQueen(int N) {
        int arr[][] = new int[4][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = 0;
            }
        }

        if (!solveQueenUtil(arr, 0))
            System.out.println("Not passsible saar");
        else
            printArray(arr);
        return arr;
    }

    private static boolean solveQueenUtil(int[][] arr, int col) {
        if (col >= arr.length)
            return true;
        for (int i = 0; i < arr.length; i++) {
            if (isSafe(arr, i, col)) {
                arr[i][col] = 1;

                if (solveQueenUtil(arr, col + 1) == true)
                    return true;
            }
            arr[i][col] = 0;
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;

    }

    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


}
