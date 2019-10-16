package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberGreaterThanSelf {

    public static void main(String[] args) {
        int arr[] = {5,2,6,1};
        List<Integer> result = getMax(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "->" + result.get(i));
        }
    }

    private static List<Integer> getMax(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> sorted = new ArrayList<Integer>();

        for(int i=nums.length-1; i>=0; i--){
            if(sorted.isEmpty()){
                sorted.add(nums[i]);
                result.add(0);
            }else if(nums[i]>sorted.get(sorted.size()-1)){
                sorted.add(sorted.size(), nums[i]);
                result.add(sorted.size()-1);
            }else{
                int l=0;
                int r=sorted.size()-1;

                while(l<r){
                    int m = l + (r-l)/2;

                    if(nums[i]>sorted.get(m)){
                        l=m+1;
                    }else{
                        r=m;
                    }
                }

                sorted.add(r, nums[i]);
                result.add(r);
            }
        }

        Collections.reverse(result);

        return result;
    }


}
