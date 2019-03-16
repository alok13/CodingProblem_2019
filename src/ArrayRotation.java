public class ArrayRotation {
    public static void main(String[] args) {
        int n = 3;
        int[] arr={3, 8, 9, 7, 6};
        int[] array=solution(arr,n);
       for(int i=0;i<array.length;i++)
        System.out.println(array[i]);
    }


    public static int[] solution(int[] A, int K) {
        int times= K%A.length;
        int[] finalArray=new int[A.length];
        int n=A.length-times;
        int j=0;
        for(int i=n;i<A.length;i++,j++){
            finalArray[j]=A[i];
        }
        for(int i=0;i<n;i++,j++){
            finalArray[j]=A[i];
        }
        return finalArray;
    }
}
