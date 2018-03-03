package LinkedLists;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(1);
        A.next.next = new ListNode(2);
        A = deleteDuplicates(A);
        while(A != null){
            System.out.print(A.val + " ");
            A = A.next;
        }
        System.out.println("\n");

        A = new ListNode(1);
        A.next = new ListNode(1);
        A.next.next = new ListNode(2);
        A.next.next.next = new ListNode(3);
        A.next.next.next.next = new ListNode(3);
        A = deleteDuplicates(A);
        while(A != null){
            System.out.print(A.val + " ");
            A = A.next;
        }
    }

    static ListNode deleteDuplicates(ListNode A) {
        ListNode currNode = A;

        while(currNode.next != null) {
            if(currNode.val == currNode.next.val)
                currNode.next = currNode.next.next;
            else
                currNode = currNode.next;
        }
        return A;
    }
}
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}