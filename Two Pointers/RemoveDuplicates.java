import java.util.*;

public class RemoveDuplicates {

    public static int remove_duplicates(int[] array){
        int non_dup = 1;
        for (int i = 1; i < array.length; i++){
            if (array[non_dup - 1] != array[i]){
                array[non_dup] = array[i];
                non_dup += 1;
            }
        }
        return non_dup;
    }
    
    public static void main(String[] args) {
        int[] array = new int[]{0,1,1,3,4,5,5,5,6,6};
        System.out.println(RemoveDuplicates.remove_duplicates(array));
    }  
}
