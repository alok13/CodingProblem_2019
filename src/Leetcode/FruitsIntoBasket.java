package Leetcode;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FruitsIntoBasket {
    public static void main(String[] args) {
        //int[] arr = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        //int[] arr = {0,1, 2, 1};
        int[] arr = {1,0,1,4,1,4,1,2,3};
        int result = getResult(arr);
        System.out.println(result);
    }

    private static int getResult(int[] arr) {
        int count=0;
        Map<Integer, Integer> fruitMap = new HashMap<>();
        int i=0;
        int j=0;
        int max=1;
        while(j<arr.length){
            if(fruitMap.size()<3){
                fruitMap.put(arr[j],j++);
            }
            if(fruitMap.size()>2){
                int min=arr.length-1;
                for(int value:fruitMap.values()){
                    min=Math.min(min,value);
                }
                i=min+1;
                fruitMap.remove(arr[min]);
            }
            max=Math.max(max,j-i);
        }
       return max;
    }
}
