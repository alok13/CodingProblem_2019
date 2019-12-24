public class NumberOfOffice {

    public static void main(String[] args) {
//        int[][] arr = {{1, 1, 1, 1, 1},
//                {1, 0, 0, 0, 1},
//                {1, 0, 0, 0, 0},
//                {1, 1, 1, 0, 1}};

       int[][]arr={{1,1,0,0,0},
                   {1,1,0,0,0},
                   {0,0,1,0,0},
                   {0,0,0,1,1}};

       //int result = getNumberOfOffices(arr);
        //System.out.println(result);
    }

    private static int getNumberOfOffices(String[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int count = 0;
        boolean visited[][] = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && arr[i][j] == "1") {
                    DFS(arr, i, j, visited);
                    count++;
                } else {
                    visited[i][j] = true;
                }
            }
        }
        return count;
    }

    private static void DFS(String[][] arr, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        int rowNbr[] = new int[]{-1, 0, 0, 1};
        int colNbr[] = new int[]{0, -1, 1, 0};
        for (int k = 0; k < 4; k++) {
            int r = row + rowNbr[k];
            int c = col + colNbr[k];
            if(isPossible(c, r, visited, arr))
            DFS(arr, r, c, visited);
        }

    }

    private static boolean isPossible(int c, int r, boolean[][] matrix, String[][] arr) {
        return c >= 0 && r >= 0 && r < matrix.length && c < matrix[0].length && !matrix[r][c] && arr[r][c] == "1";
    }
}
