public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1,  2,  3,  4,  5,  6,  7,  8},
                        {9, 10, 11, 12, 13, 14, 15, 16},
                        {17, 18, 19, 20, 21, 22, 23, 24}};
        printMatrix(arr);
    }

    private static void printMatrix(int[][] arr) {
        int x_curr = 0;
        int y_curr = 0;
        int x_length = arr[0].length;
        int y_length = arr.length;
        int count = 0;
        int x_limit = x_length;
        int y_limit = y_length;
        int number = x_length * y_length;

        while (count <= number) {
            for (int i = x_curr; i < x_limit; x_curr = i, i++) {
                count++;
                if (count > number)
                    break;
                System.out.print(arr[y_curr][i] + " ");
            }
            y_curr++;
            System.out.println();
            for (int i = y_curr; i < y_limit; y_curr = i, i++) {
                count++;
                if (count > number)
                    break;
                System.out.print(arr[i][x_curr] + " ");
            }
            x_curr--;
            x_limit--;
            System.out.println();
            for (int i = x_curr; i >= 0; x_curr = i, i--) {
                count++;
                if (count > number)
                    break;
                System.out.print(arr[y_curr][i] + " ");

            }
            y_curr--;

            System.out.println();
            for (int i = y_curr; i > 0; y_curr = i, i--) {
                count++;
                if (count > number)
                    break;
                System.out.print(arr[i][x_curr] + " ");
            }
            x_curr++;
            y_limit--;
            System.out.println();
        }


    }
}
