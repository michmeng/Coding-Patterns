import java.util.*;

public class Appointment {
    
    public static boolean allAppointments(Interval[] intervals){
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        for (int i = 0; i < intervals.length - 1; i++){
            if (intervals[i].end > intervals[i+1].start){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Interval[] intervals = {new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)};
        System.out.println(Appointment.allAppointments(intervals)); 

        Interval[] intervals1 = {new Interval(6, 7), new Interval(2, 4), new Interval(8, 12)};
        System.out.println(Appointment.allAppointments(intervals1)); 

        Interval[] intervals2 = {new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)};
        System.out.println(Appointment.allAppointments(intervals2)); 
    }
}
