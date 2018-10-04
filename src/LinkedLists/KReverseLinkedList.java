package LinkedLists;

import java.util.List;

public class KReverseLinkedList {

    public static void main(String[] args) {

    }

    static ListNode reverse(ListNode A, int B) {
        /*Could not solve myself in an hour, taken from internet */
        ListNode current = A;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;

        /* Reverse first k ListNodes of linked list */
        while (count < B && current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

       /* next is now a pointer to (k+1)th ListNode
          Recursively call for the list starting from current.
          And make rest of the list as next of first ListNode */
        if (next != null)
            A.next = reverse(next, B);

        // prev is now A of input list
        return prev;
    }
}
