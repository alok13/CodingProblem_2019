package agoda;

import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test4 {
    public static void main(String[] args) {
        int arr[]={203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
        int brr[]={203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
        int result[]=missingNumbers(arr,brr);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }

    static int[] missingNumbers(int[] arr, int[] brr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int count = map.get(arr[i]);
                map.put(arr[i], count + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (int i = 0; i < brr.length; i++) {
            if (map.containsKey(brr[i])) {
                int count = map.get(brr[i]);
                if (count == 1) {
                    map.remove(brr[i]);
                } else
                    map.put(brr[i], count - 1);
            } else {
                map.put(brr[i], 1);
            }
        }
        SortedSet<Integer> keys = new TreeSet<>(map.keySet());

        int[] result = new int[map.size()];
        int i=0;
        for ( int key : keys ) {
           result[i]=key;
           i++;
        }
       return result;

    }

}
