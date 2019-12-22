package Older;

public class FindOddInArray {
    public static void main(String[] args) {
        int[] i = {};

        System.out.println(findOddInArray(i));
    }

    private static int findOddInArray(int[] arr) {
        int result=arr[0];
        for(int i=1;i<arr.length;i++)
            result=result^arr[i];

        return result;
    }
}
