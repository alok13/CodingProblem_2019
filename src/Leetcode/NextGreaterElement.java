package Leetcode;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[]= {4, 5, 2, 25};
        findGreaterElement(arr);
    }

    private static void findGreaterElement(int[] arr) {
        Stack<Integer> s=new Stack();

        s.push(arr[0]);

        for(int i=1;i<arr.length;i++) {
            int next = arr[i];
            if (!s.isEmpty()) {
                int element = s.pop();

                while (element < next) {
                    System.out.println(element + " --> " + next);
                    if (s.isEmpty())
                        break;
                    element = s.pop();
                }

                /* If element is greater than next, then
                   push the element back */
                if (element > next)
                    s.push(element);
            }


            s.push(next);
        }
            while (s.isEmpty() == false)
            {
               int element = s.pop();
                int next = -1;
                System.out.println(element + " -- " + next);
            }


    }

}
