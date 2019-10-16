package Leetcode;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        System.out.println(findLca(tree, 4, 6).data);
    }

    static Node findLca(Node root, int n, int m) {
        if (root == null)
            return null;
        if (root.data == n || root.data == m)
            return root;

        Node left_lca = findLca(root.left, n, m);
        Node right_lca = findLca(root.right, n, m);
        if (left_lca != null && right_lca != null)
            return root;
        return (left_lca != null) ? left_lca : right_lca;
    }
}


class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}
