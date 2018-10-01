package LinkedLists;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ReverseLinkListII {

    public static void main(String[] args) {
        ListNode A = reverseBetween(new ListNode(1), 1, 1);
        while(A!= null) {
            System.out.print(A.val + " ");
            A = A.next;
        }

        ListNode C = new ListNode(1);
        ListNode D = new ListNode(2);
        ListNode E = new ListNode(3);
        C.next = D;
        D.next = E;
        ListNode B = reverseBetween(C, 1, 2);
        while(B!= null) {
            System.out.print(B.val + " ");
            B = B.next;
        }

    }

    static ListNode reverseBetween(ListNode A, int B, int C) {

        //int storeAmount = Math.abs(B-C) + 1;

        ListNode root = A;
        ListNode prevNode = null;
        ListNode afterNode = null;
        int counter = 1;
        Stack<ListNode> stack = new Stack<>();

        while(counter <= C && A != null) {
            if(counter == B - 1)
                prevNode = A;
            else if(counter == C)
                afterNode = A.next;

            if(counter >= B && counter <=C){
                stack.add(A);
            }
            A = A.next;
            counter++;
        }
        while(stack.size() > 0){
            if(prevNode != null){
                prevNode.next = stack.pop();
                prevNode = prevNode.next;
            }
            else {
                prevNode = stack.pop();
                root = prevNode;
            }
        }
        if(prevNode != null)
            prevNode.next = afterNode;

        return root;

    }
}
