package LinkedLists;

import LinkedLists.ListNode;

import java.util.List;

public class RemoveDuplicatesfromSortedListII {

    public static void main(String[] args) {
        deleteDuplicates(new ListNode(1));
    }

    /*
        currVal
        duplicateFound
        for the list


     */
    private static ListNode deleteDuplicates(ListNode A) {
        ListNode root = A;

        boolean duplicateStreak = false;
        ListNode prev = null;
        while(A.next != null) {

            if(A.val == A.next.val){
                duplicateStreak = true;
            }
            else if(duplicateStreak){

                if(prev != null){
                    prev.next = A.next;
                }
                else{
                    root = A.next;
                }
                duplicateStreak = false;
            }
            else
                prev = A;
            A = A.next;
        }
        //System.out.println("prev null: "+ (prev == null));
        if(duplicateStreak){
            if(prev != null){
                prev.next = A.next;
            }
            else{
                root = A.next;
            }

        }


        return root;
    }
}
