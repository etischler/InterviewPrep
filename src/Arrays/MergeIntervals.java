package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    public static void main(String[] args) {

//        print(insert(new ArrayList<>(Arrays.asList(
//                new Interval(1,3),
//                new Interval(6, 9)
//                )),new Interval(2,5)));

        print(insert(new ArrayList<>(Arrays.asList(
                new Interval(1,2),
                new Interval(3, 5),
                new Interval(6, 7),
                new Interval(8, 10),
                new Interval(12, 16)

        )),new Interval(4,9)));

    }

    static void print(ArrayList<Interval> intervalsToPrint) {
        for(int i = 0; i < intervalsToPrint.size(); i++) {
            System.out.print("{" + intervalsToPrint.get(i).start + " ," +intervalsToPrint.get(i).end + "}, ");
        }
        System.out.print("\n");
    }

    static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> newIntervals = new ArrayList<>();
        int newEnd = newInterval.end;
        int newStart = newInterval.start;
        for(int i = 0; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            int start = current.start;
            int end = current.end;

            if(newEnd < start && (i == 0 || (i - 1 >= 0 && newStart > intervals.get(i - 1).end))) {
                newIntervals.add(newInterval);
                newIntervals.add(current);
            }
            else if(newStart > end && (i == intervals.size() - 1 || (i + 1 < intervals.size() && newEnd < intervals.get(i + 1).start))) {
                newIntervals.add(current);
                newIntervals.add(newInterval);
            }
            else if(newStart < start && newEnd > end){
                continue;
            }
            else if(newStart > start && newEnd >= end) {
                if(i == intervals.size() - 1 || newEnd < intervals.get(i + 1).end)
                    newIntervals.add(new Interval(start, newEnd));
                else
                    newIntervals.add(current);
            }
            else if(newEnd < end && newStart <= start) {
                if(i - 1 >= 0 && intervals.get(i - 1).end == newStart){
                    intervals.get(i - 1).end = current.end;
                }
                else if(i == 0 || newStart > intervals.get(i - 1).start){
                    newIntervals.add(new Interval(newStart, current.end));
                }
                else
                    newIntervals.add(current);
            }
        }

        return newIntervals;
    }
}

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }