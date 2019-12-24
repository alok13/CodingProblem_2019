package NovemberChallenge;

public class Test1 {
    public static void main(String[] args) {
        int arr[]={3,2,1,3};
        int result=birthdayCakeCandles(arr);
        System.out.println(result);
    }

    private static int birthdayCakeCandles(int[] arr) {
        if(arr==null || arr.length==0)
            return 0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max)
                max=arr[i];
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==max)
                count++;
        }
        return arr.length-count;
    }
}
