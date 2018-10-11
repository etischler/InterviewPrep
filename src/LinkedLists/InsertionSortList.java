package LinkedLists;

public class InsertionSortList {

    public static void main(String[] args) {

    }

    static ListNode insertionSortList(ListNode A) {

        ListNode root = new ListNode(A.val);
        A = A.next;
        ListNode B = root;
        while(A != null){

            while(B != null) {

                if(A.val < root.val){
                    ListNode temp = root;
                    root = new ListNode(A.val);
                    root.next = temp;
                    B = root;
                    break;
                }
                else if(A.val > B.val && B.next != null && A.val <= B.next.val){
                    ListNode temp = B.next;
                    B.next = new ListNode(A.val);
                    B.next.next = temp;
                    B = root;
                    break;
                }
                else if(B.next == null && A.val > B.val){
                    B.next = new ListNode(A.val);
                    B = root;
                    break;
                }
                B = B.next;
            }


            A = A.next;
        }
        return root;
    }
}
