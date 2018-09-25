package LinkedLists;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

    }

    static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode root = null;
        ListNode cursor = null;
        while(A != null || B != null) {
            if(A != null && B != null) {
                if(A.val < B.val){
                    if(root == null){
                        root = new ListNode(A.val);
                        cursor = root;
                    }
                    else {
                        cursor.next = new ListNode(A.val);
                        cursor = cursor.next;
                    }
                    A = A.next;
                }
                else{
                    if(root == null){
                        root = new ListNode(B.val);
                        cursor = root;
                    }
                    else {
                        cursor.next = new ListNode(B.val);
                        cursor = cursor.next;
                    }
                    B = B.next;
                }
            }
            else if(B != null){
                if(root == null){
                    root = new ListNode(B.val);
                    cursor = root;
                }
                else {
                    cursor.next = new ListNode(B.val);
                    cursor = cursor.next;
                }
                B = B.next;
            }
            else{
                if(root == null){
                    root = new ListNode(A.val);
                    cursor = root;
                }
                else {
                    cursor.next = new ListNode(A.val);
                    cursor = cursor.next;
                }
                A = A.next;
            }
        }
        return root;
    }
}
