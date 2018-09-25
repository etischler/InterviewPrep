package LinkedLists;

import java.util.LinkedList;

public class RemoveNthNodeFromListEnd {

    public static void main(String[] args) {

    }

    static ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode rootNode = A;

        LinkedList<ListNode> nodeQueue = new LinkedList();
        while(A != null) {
            if(nodeQueue.size() < B + 1) {
                nodeQueue.add(A);
            }
            else{
                nodeQueue.pop();
                nodeQueue.add(A);

            }

            A = A.next;
        }
        if(nodeQueue.size() > B) {
            ListNode left = nodeQueue.pop();
            nodeQueue.pop();
            ListNode right = null;
            if(nodeQueue.size() > 0) {
                right = nodeQueue.pop();
            }
            left.next = right;
            return rootNode;
        }
        else if(nodeQueue.size() == B) {
            return rootNode.next;
        }
        else {
            return rootNode.next;
        }
    }
}
