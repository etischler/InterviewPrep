package Strings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class ZigZag {

    public static void main(String[] args) {

        System.out.println(convert("PAYPALISHIRING",3));
        System.out.println(convert("ABCD",2));
        System.out.println(convert("kHAlbLzY8Dr4zR0eeLwvoRFg9r23Y3hEujEqdio0ctLh4jZ1izwLh70R7SAkFsXlZ8UlghCL95yezo5hBxQJ1Td6qFb3jpFrMj8pdvP6M6k7IaXkq21XhpmGNwl7tBe86eZasMW2BGhnqF6gPb1YjCTexgCurS",1));

    }

    static String convert(String A, int B) {
        List<Queue> queues = new ArrayList<>();
        for(int i = 0 ; i < B; i++) {
            queues.add(new LinkedList<>());
        }
        boolean goingRight = true;
        ListIterator iterator = queues.listIterator();
        for(int i = 0; i < A.length(); i++) {
            if(goingRight && !iterator.hasNext())
            {
                goingRight = false;
                if(B > 1)
                    iterator.previous();
            }
            if(!goingRight && !iterator.hasPrevious())
            {
                goingRight = true;
                if(B > 1)
                    iterator.next();
            }
            if(goingRight){
                ((Queue) iterator.next()).add(A.charAt(i));
            }
            else {
                ((Queue) iterator.previous()).add(A.charAt(i));
            }
        }
        iterator = queues.listIterator();
        String ans = "";
        while(iterator.hasNext()) {
           Queue queue =  ((Queue) iterator.next());
           while(!queue.isEmpty()){
               ans += queue.poll();
           }
        }
        return ans;
    }
}
