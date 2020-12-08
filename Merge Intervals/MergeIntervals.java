import java.util.*;

class Interval{
    int start;
    int end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class MergeIntervals {
    
    public static List<Interval> merge(List<Interval> intervals){
        if (intervals.size() < 2){
            return intervals;
        }
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;

        while (intervalItr.hasNext()){
            interval = intervalItr.next();
            if (interval.start <= end){
                end = Math.max(interval.end, end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }


    public static void main(String[] args){
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,4));
        input.add(new Interval(2,5));
        input.add(new Interval(7,9));
        List<Interval> result = MergeIntervals.merge(input);
        for (Interval interval : result){
            System.out.println(interval.start);
            System.out.println(interval.end);
        }

        System.out.println("******************");

        List<Interval> input2 = new ArrayList<Interval>();
        input2.add(new Interval(6,7));
        input2.add(new Interval(2,4));
        input2.add(new Interval(5,9));
        List<Interval> result2 = MergeIntervals.merge(input2);
        for (Interval interval : result2){
            System.out.println(interval.start);
            System.out.println(interval.end);
        }

        System.out.println("******************");

        List<Interval> input3 = new ArrayList<Interval>();
        input3.add(new Interval(1,4));
        input3.add(new Interval(2,6));
        input3.add(new Interval(4,5));
        List<Interval> result3 = MergeIntervals.merge(input3);
        for (Interval interval : result3){
            System.out.println(interval.start);
            System.out.println(interval.end);
        }
    }
}
