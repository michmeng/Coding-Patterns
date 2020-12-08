import java.util.*;

public class IntervalIntersection {
    
    public static Interval[] merge(Interval[] arr1, Interval[] arr2){
        List<Interval> mergedIntervals = new ArrayList<Interval>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length){
            if ((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end) || (arr2[i].start >= arr1[j].start && arr2[i].start <= arr1[j].end)){
                    mergedIntervals.add(new Interval(Math.max(arr1[i].start, arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));
                }    
            if (arr1[i].end < arr2[j].end){
                i++;
            } else {
                j++;
            }
            }
            return mergedIntervals.toArray(new Interval[mergedIntervals.size()]);
        }

    public static void main(String[] args){
        Interval[] input1 = new Interval[] {new Interval(1,3), new Interval(5,6), new Interval(7,9)};
        Interval[] input2 = new Interval[] {new Interval(2,3), new Interval(5,7)};
        Interval[] result = IntervalIntersection.merge(input1, input2);
        for (Interval interval: result){
            System.out.println("[" + interval.start + "," + interval.end + "]");
        }
        System.out.println();

        Interval[] input3 = new Interval[] {new Interval(1,3), new Interval(5,7), new Interval(9,12)};
        Interval[] input4 = new Interval[] {new Interval(5,10)};
        Interval[] result2 = IntervalIntersection.merge(input3, input4);
        for (Interval interval: result2){
            System.out.println("[" + interval.start + "," + interval.end + "]");
        }
        System.out.println();
    }

}