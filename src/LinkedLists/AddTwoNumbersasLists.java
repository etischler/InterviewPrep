package LinkedLists;

import java.util.List;

public class AddTwoNumbersasLists {

    public static void main(String[] args) {

    }

    static ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode root = null;
        ListNode curr= null;
        ListNode lastNonZeroNode = null;

        boolean carryBit = false;
        int sum = 0;
        while(A!= null || B != null) {

            if(A!= null && B!= null){
                sum = carryBit ? A.val + B.val + 1 : A.val + B.val;
            }
            else if(A!=null){
                sum = carryBit ? A.val + 1 : A.val;
            }
            else {
                sum = carryBit ? B.val + 1 : B.val;
            }
            carryBit = false;

            if(sum >= 10){
                carryBit = true;
                sum -= 10;
            }
            if(root == null){
                root = new ListNode(sum);
                curr = root;
            }
            else{
                curr.next = new ListNode(sum);
                curr = curr.next;
            }
            if(sum > 0){
                lastNonZeroNode = curr;
            }

            if(A != null)
                A = A.next;
            if(B!= null)
                B = B.next;
        }

        if(carryBit) {
            curr.next = new ListNode(1);
            lastNonZeroNode = curr.next;
        }


        if(lastNonZeroNode != null)
            lastNonZeroNode.next = null;



        return root;
    }
}
