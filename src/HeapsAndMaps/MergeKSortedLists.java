package HeapsAndMaps;

import LinkedLists.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class MergeKSortedLists {

    public static void main(String[] args) {

    }

    static ListNode mergeKLists(ArrayList<ListNode> a) {

        class comparator implements Comparator<ListNode> {

            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val == o2.val)
                    return o1.hashCode() - o2.hashCode();
                else
                    return o1.val - o2.val;
            }
        }

        TreeSet<ListNode> set = new TreeSet<>(new comparator());

        for(ListNode currNodei : a){
            ListNode curr = currNodei;
            while(curr != null){
                set.add(curr);


                curr = curr.next;
            }
        }
        if(set.size() == 0){
            return null;
        }
        ListNode before = set.pollFirst();
        ListNode root = before;

        while(set.size() > 0){
            before.next = set.pollFirst();
            before = before.next;
        }

        before.next = null;

        return root;
    }
}
