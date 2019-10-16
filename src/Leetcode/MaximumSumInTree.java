package Leetcode;

public class MaximumSumInTree {


    public static void main(String[] args) {

        Node node = new Node(-15);
        node.left = new Node(5);
        node.right = new Node(6);
        node.left.left = new Node(-8);
        node.left.right = new Node(1);
        node.left.left.left = new Node(2);
        node.left.left.right = new Node(6);
        node.right.left = new Node(3);
        node.right.right = new Node(9);
        node.right.right.right = new Node(0);
        node.right.right.right.left = new Node(4);
        node.right.right.right.right = new Node(-1);
        node.right.right.right.right.left = new Node(10);
        int[] max_values = {Integer.MIN_VALUE};
        int result = getSum(node, max_values);
        System.out.println(result);
        System.out.println(max_values[0]);
    }

    private static int getSum(Node node, int[] max_values) {
        if (node == null)
            return 0;
        int left =Math.max(0, getSum(node.left, max_values));
        int right = Math.max(0,getSum(node.right, max_values));
        max_values[0] = Math.max(left + right + node.data, max_values[0]);
        return Math.max(left, right) + node.data;

    }
}
