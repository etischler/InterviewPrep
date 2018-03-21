package Arrays;

import java.lang.reflect.Array;
import java.util.*;

public class HotelBookingsPossible {

    public static void main(String[] args) {
        ArrayList<Integer> arrivals1 = new ArrayList<>(Arrays.asList(1,3,5));
        ArrayList<Integer> departures1 = new ArrayList<>(Arrays.asList(2,6,8));
        System.out.println(hotel(arrivals1, departures1, 1));

        ArrayList<Integer> arrivals2 = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> departures2 = new ArrayList<>(Arrays.asList(10,2,6,14));
        System.out.println(hotel(arrivals2, departures2, 4));

        ArrayList<Integer> arrivals3 = new ArrayList<>(Arrays.asList(1,3,4));
        ArrayList<Integer> departures3 = new ArrayList<>(Arrays.asList(12,8,6));
        System.out.println(hotel(arrivals3, departures3, 2));

        ArrayList<Integer> arrivals4 = new ArrayList<>(Arrays.asList(17, 0, 45, 11, 16, 43, 15, 42, 2, 41, 0, 27, 37, 25, 17, 42, 24, 23, 11, 4, 29, 39, 6, 10, 42, 16, 17, 39, 1));
        ArrayList<Integer> departures4 = new ArrayList<>(Arrays.asList( 25, 24, 52, 51, 26, 46, 25, 45, 9, 51, 49, 48, 51, 66, 65, 57, 69, 43, 50, 9, 32, 55, 10, 58, 62, 46, 19, 87, 12));
        System.out.println(hotel(arrivals4, departures4, 16));

        ArrayList<Integer> arrivals5 = new ArrayList<>(Arrays.asList(23, 44, 37, 42, 27, 32, 25, 10, 20, 3, 28, 23, 21, 5, 21, 34));
        ArrayList<Integer> departures5 = new ArrayList<>(Arrays.asList( 71, 71, 78, 90, 31, 38, 58, 52, 40, 6, 56, 55, 21, 10, 55, 81));
        System.out.println(hotel(arrivals5, departures5, 9));

        ArrayList<Integer> arrivals6 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> departures6 = new ArrayList<>(Arrays.asList(2, 3, 4));
        System.out.println(hotel(arrivals6, departures6, 1));


    }

    static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

        List<Node> timeline = new LinkedList<>();

        for(int value : arrive) {
            timeline.add(new Node(value, true));
        }
        for(int value : depart){
            timeline.add(new Node(value, false));
        }

        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        };

        Collections.sort(timeline, comparator);

        int numGuest = 0;
        for(int i = 0; i < timeline.size(); i++){
            if(timeline.get(i).upEvent)
                numGuest++;
            else
                numGuest--;

            if(numGuest > K)
            {
                if(i == timeline.size() - 1)
                    return false;
                else if(!(timeline.get(i).value == timeline.get(i + 1).value) || timeline.get(i+1).upEvent)
                    return false;
            }
        }

        return true;
    }

}

class Node{
    int value;
    Boolean upEvent;

    public Node(int value, Boolean upEvent){
        this.value = value;
        this.upEvent = upEvent;
    }
}