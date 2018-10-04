package LinkedLists;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ReOrderList {

    public static void main(String[] args) {
        testOne();
        testTwo();

    }

    private static void testTwo() {
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(4);
        ListNode E = new ListNode(5);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        A = reorderList(A);
        while(A != null){
            System.out.println(A.val);
            A = A.next;
        }
    }

    private static void testOne() {
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(4);
        A.next = B;
        B.next = C;
        C.next = D;
        A = reorderList(A);
        while(A != null){
            System.out.println(A.val);
            A = A.next;
        }
    }

    static ListNode reorderList(ListNode A) {
        ListNode root = A;
        Stack<ListNode> stack = new Stack<>();
        Queue<ListNode> queue = new LinkedList<>();

        while(A != null){
            queue.add(A);
            stack.add(A);
            A = A.next;
        }

        ListNode queueNode = null;
        ListNode stackNode = null;
        ListNode prevStackNode = null;
        while(true){
            queueNode = queue.poll();
            stackNode = stack.pop();
            if(queueNode == stackNode)
                break;
            if(queueNode == prevStackNode)
                break;
            queueNode.next = stackNode;

            if(prevStackNode == null){
                prevStackNode = stackNode;
            }
            else{
                prevStackNode.next = queueNode;
                prevStackNode = stackNode;
            }
        }
        if(queueNode == stackNode && prevStackNode != null) {
            prevStackNode.next = queueNode;
            queueNode.next = null;
        }
        else if(prevStackNode != null && prevStackNode == queueNode)
            prevStackNode.next = null;

        return root;
    }
}
