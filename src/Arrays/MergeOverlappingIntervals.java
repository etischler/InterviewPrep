package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
/* RAN OUT OF TIME TO CLEANUP, BUT GOT CORRECT SOLVE */
public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        print(merge(new ArrayList<>(Arrays.asList(
                new Interval(1 , 3),
                new Interval(2 , 6),
                new Interval(8 , 10),
                new Interval(15 , 18)
        ))));

        print(merge(new ArrayList<>(Arrays.asList(
                new Interval(92, 98),
                new Interval(10, 86),
                new Interval(61, 91),
                new Interval(8, 71),
                new Interval(53, 65),
                new Interval(19, 79),
                new Interval(20, 50)
        ))));

        print(merge(new ArrayList<>(Arrays.asList(
                new Interval(93, 94),
                new Interval(26, 28),
                new Interval(57, 79),
                new Interval(15, 34),
                new Interval(1, 56),
                new Interval(36, 51),
                new Interval(47, 64),
                new Interval(11, 16)
        ))));
    }



    static void print(ArrayList<Interval> intervalsToPrint) {
        for(int i = 0; i < intervalsToPrint.size(); i++) {
            System.out.print("{" + intervalsToPrint.get(i).start + " ," + intervalsToPrint.get(i).end + "}, ");
        }
        System.out.print("\n");
    }
    static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals.size() == 0)
            return new ArrayList<>();

        Collections.sort(intervals, new ColorComparator());
        //print(intervals);
        ArrayList<Interval> newIntervals = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        int max = intervals.get(0).end;
        for(int i = 0; i < intervals.size(); i++) {
            int thisEnd = intervals.get(i).end;
            int nextEnd = (i + 1 < intervals.size()) ? intervals.get(i + 1).end : -1;
            int nextStart = (i + 1 < intervals.size()) ? intervals.get(i + 1).start : -1;
            max = Math.max(thisEnd, max);
            if(max >= nextStart && !(i == intervals.size() - 1)) {

                continue;
            }
            else {

                newIntervals.add(new Interval(start, max));
                if(i + 1 < intervals.size()) {
                    start = intervals.get(i + 1).start;
                    end = intervals.get(i + 1).end;
                }
            }
        }

        return newIntervals;
    }
}
 class ColorComparator implements Comparator<Interval>
{
    public int compare(Interval c1, Interval c2)
    {
        return c1.start - c2.start;
    }
}