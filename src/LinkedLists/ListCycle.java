package LinkedLists;

import java.util.HashSet;

public class ListCycle {

    public static void main(String[] args) {

    }

    static ListNode detectCycle(ListNode a) {
        HashSet<ListNode> s = new HashSet<ListNode>();
        while (a != null)
        {
            // If we have already has this node
            // in hashmap it means their is a cycle
            // (Because you we encountering the
            // node second time).
            if (s.contains(a))
                return a;

            // If we are seeing the node for
            // the first time, insert it in hash
            s.add(a);

            a = a.next;
        }

        return null;
    }
}
