package Leetcode;

public class BSTFromSortedArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        getBST(arr, 0, arr.length - 1);
    }

    private static Node1 getBST(int[] arr, int i, int j) {
        if (i > j)
            return null;
        int mid = (i + j) / 2;
        Node1 root = new Node1(arr[mid]);
        root.left = getBST(arr, 0, mid);
        root.right = getBST(arr, mid + 1, j);

        return root;
    }
}

class Node1 {

    int data;
    Node1 left, right;

    Node1(int d) {
        data = d;
        left = right = null;
    }
}