package LinkedLists;

public class PartitionList {

    public static void main(String[] args) {

    }

    static ListNode partition(ListNode A, int B) {

        ListNode lessThan = null;
        ListNode greaterEqualto = null;
        ListNode root = null;
        ListNode oddScenarioRoot = null;
        while(A != null) {
            if(A.val < B) {
                if(lessThan == null) {
                    lessThan = new ListNode(A.val);
                    root = lessThan;
                }
                else {
                    lessThan.next = new ListNode(A.val);
                    lessThan = lessThan.next;
                }
            }
            else{
                if(greaterEqualto == null){
                    greaterEqualto = new ListNode(A.val);
                    oddScenarioRoot = greaterEqualto;
                }
                else {
                    greaterEqualto.next = new ListNode(A.val);
                    greaterEqualto = greaterEqualto.next;
                }
            }

            A = A.next;
        }

        if(lessThan != null)
            lessThan.next = oddScenarioRoot;

        if(root == null && oddScenarioRoot != null)
            root = oddScenarioRoot;
        return root;
    }
}
