package Leetcode;

public class CopyList {

    public static void main(String[] args) {
        Node_3 node=new Node_3();
        Node_3 node1=new Node_3();
        node1.val=2;
        node1.next=null;
        node1.random=node1;
        node.val=1;
        node.next=node1;
        node.random=node1;

        Node_3 node_1=copyRandomList(node);
    }

    static Node_3 copyRandomList(Node_3 node){
        Node_3 head=node;
        if(node==null)
            return null;
        Node_3 head_new=null;
        while(node.next!=null){
            Node_3 node1=new Node_3(node.val,node.next,null);
            node=node.next;
            if(head_new==null)
                head_new=node1;
        }
        Node_3 head_2=head_new;
        while(head.next!=null){
            head_2.random=head.random;
            head=head.next;
            head_2=head_2.next;
        }
        return head_new;
    }
}


// Definition for a Node.
class Node_3 {
    public int val;
    public Node_3 next;
    public Node_3 random;

    public Node_3() {}

    public Node_3(int _val,Node_3 _next,Node_3 _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}


