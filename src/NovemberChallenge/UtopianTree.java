package NovemberChallenge;

public class UtopianTree {
    public static void main(String[] args) {
        int k=2;
        int arr[]={1,5,3,4,2};
        int result=getDifference(k,arr);
        System.out.println(result);
    }

    private static int getDifference(int k, int[] arr) {
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(Math.abs(arr[i]-arr[j])==k){
                    count++;
                }
            }
        }
        return count;
    }
}
