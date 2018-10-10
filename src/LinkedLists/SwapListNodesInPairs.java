package LinkedLists;

public class SwapListNodesInPairs {

    public static void main(String[] args) {

    }

    static ListNode swapPairs(ListNode A) {
        // If linked list is empty or there is only one A in list
        if (A == null || A.next == null) {
            return A;
        }

        // Initialize previous and current pointers
        ListNode prev = A;
        ListNode curr = A.next;

        A = curr;  // Change head before proceeeding

        // Traverse the list
        while (true) {
            ListNode next = curr.next;
            curr.next = prev; // Change next of current as previous A

            // If next NULL or next is the last A
            if (next == null || next.next == null) {
                prev.next = next;
                break;
            }

            // Change next of previous to next next
            prev.next = next.next;

            // Update previous and curr
            prev = next;
            curr = prev.next;
        }
        return A;
    }
}
