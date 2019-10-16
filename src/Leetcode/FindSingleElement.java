package Leetcode;

/*
Given a sorted array in which all elements appear twice (one after one) and one element appears only once. Find that element in O(log n) complexity.
O(logn) is better than O(n)
 */
public class FindSingleElement {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 4, 4, 5, 5, 6, 6};
        System.out.println(search(arr, 0, arr.length-1));
    }

    private static int search(int[] arr, int i, int j) {
        int mid= (i+j)/2;
        if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1])
            return arr[mid];
        else if(mid%2!=0)
          return  search(arr,mid+1,j);
        else
           return search(arr,i,mid-1);
    }
}
