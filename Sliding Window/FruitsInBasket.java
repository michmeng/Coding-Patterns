import java.util.*;

public class FruitsInBasket {

    public static int max_fruits(char[] array){
        if (array.length == 0){
            return 0;
        }
        int most_fruit = 0;
        int starting_index = 0;
        Map<Character, Integer> fruits = new HashMap<>();
        for (int i = 0; i < array.length; i++){
            fruits.put(array[i], fruits.getOrDefault(array[i], 0) + 1);
        while (fruits.size() > 2){
            fruits.put(array[starting_index], fruits.get(array[starting_index]) - 1);
            if (fruits.get(array[starting_index]) == 0){
                fruits.remove(array[starting_index]);
                }
            starting_index = starting_index + 1; 
            }
        if (most_fruit < (i - starting_index + 1)){
            most_fruit = i - starting_index + 1;
            }
        }
        return most_fruit;
    }

    public static void main(String[] args) {
        char[] array = {'A','A','B','P','B','A','B'};
        System.out.println(FruitsInBasket.max_fruits(array));
        }   
    
}
