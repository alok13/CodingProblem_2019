package Dec_2019;

import java.util.*;

public class ListToBST {

    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);
        numList.add(6);
        Node root = convertToTree(numList);
        printTree(root);
    }

    private static void printTree(Node root) {
        if (root == null) {
            System.out.println("Ille");
            return;
        }


        Queue<Node> queue = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() || !queue2.isEmpty()) {
            while (!queue.isEmpty()) {
                Node currentNode = queue.poll();
                System.out.print(currentNode.value + "    ");
                if (currentNode.left != null)
                    queue2.add(currentNode.left);
                if (currentNode.right != null)
                    queue2.add(currentNode.right);
            }

            System.out.println();
            while (!queue2.isEmpty()) {
                Node currentNode = queue2.poll();
                System.out.print(currentNode.value + "    ");
                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }
            System.out.println();

        }

    }

    private static Node convertToTree(List<Integer> numList) {
        if (numList == null || numList.size() == 0)
            return null;
        int length = numList.size();
        int mid = length / 2;

        Node root = new Node(numList.get(mid));
        Node root1 = root;
        Node root2 = root;

        for (int i = mid + 1; i < length; i++) {
            Node right = new Node(numList.get(i));
            root.right = right;
            root = right;
        }

        for (int i = mid - 1; i >= 0; i--) {
            Node left = new Node(numList.get(i));
            root1.left = left;
            root1 = left;
        }

        return root2;
    }
}


class Node {
    int value;
    Node left;
    Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }


    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}