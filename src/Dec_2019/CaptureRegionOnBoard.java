package Dec_2019;

//https://www.interviewbit.com/problems/capture-regions-on-board/
public class CaptureRegionOnBoard {

    public static void main(String[] args) {
        char[][] arr = {{'x', 'x', 'x', 'x'},
                {'x', '0', '0', 'x'},
                {'x', 'x', '0', 'x'},
                {'x', '0', 'x', 'x'}};

        int result = getRegions(arr);
        System.out.println(result);
    }

    private static int getRegions(char[][] arr) {
        int result = 0;
        for (int i = 1; i < arr.length - 1; i++)
            for (int j = 1; j < arr[0].length - 1; j++) {
                if (arr[i][j] == '0' && surroundedByX(arr, i, j)) {
                    arr[i][j] = 'x';
                }
            }

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '0') {
                    result++;
                }
            }
        return result;
    }

    private static boolean surroundedByX(char[][] arr, int i, int j) {
        return arr[i - 1][j] == 'x' && arr[i][j - 1] == 'x' && arr[i + 1][j] == 'x' && arr[i][j + 1] == 'x';
    }

}
