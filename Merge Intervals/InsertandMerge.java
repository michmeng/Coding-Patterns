import java.util.*;

public class InsertandMerge {

    public static List<Interval> mergeAndInsert(List<Interval> intervals, Interval addTo){
        if (intervals == null || intervals.isEmpty()){
            return Arrays.asList(addTo);
        }
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < addTo.start){
            mergedIntervals.add(intervals.get(i));
            i++;
        }
        while(i < intervals.size() && intervals.get(i).start <= addTo.end){
            addTo.start = Math.min(addTo.start, intervals.get(i).start);
            addTo.end = Math.max(addTo.end, intervals.get(i).end);
            i++;
        }
        mergedIntervals.add(addTo);
        while(i < intervals.size()){
            mergedIntervals.add(intervals.get(i));
            i++;
        }
        return mergedIntervals;
    }


    public static void main(String[] args){
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,3));
        input.add(new Interval(5,7));
        input.add(new Interval(8,12));
        List<Interval> result = InsertandMerge.mergeAndInsert(input, new Interval(4, 6));
        for (Interval interval : result){
            System.out.println(interval.start);
            System.out.println(interval.end);
        }

        System.out.println("******************");

        List<Interval> input2 = new ArrayList<Interval>();
        input2.add(new Interval(1,3));
        input2.add(new Interval(5,7));
        input2.add(new Interval(8,12));
        List<Interval> result2 = InsertandMerge.mergeAndInsert(input2, new Interval(4, 10));
        for (Interval interval : result2){
            System.out.println(interval.start);
            System.out.println(interval.end);
        }

        System.out.println("******************");

        List<Interval> input3 = new ArrayList<Interval>();
        input3.add(new Interval(2,3));
        input3.add(new Interval(5,7));
        List<Interval> result3 = InsertandMerge.mergeAndInsert(input3, new Interval(1, 4));
        for (Interval interval : result3){
            System.out.println(interval.start);
            System.out.println(interval.end);
        }
    }
    
}
