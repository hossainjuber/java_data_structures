package AlgoExpert;

import java.util.HashSet;
import java.util.Set;


/*
* Given a targetSum iterate over an array and return the two numbers that can sum up to
* that number, return an empty array if no such sum can be found
* */

public class TwoNumberSum {

    public static void main(String[] args){
        int[] array = {3, 5, -4, 8, 0, 1, -1, 6 };
        int target = 10;
        //twoNumberSum(array, target);
        //int[] result = getTwoNumbersForTheSum(array, target);
        int[] result = getTwoNumSum(array, target);
        if(result.length==0){
            System.out.println("Sorry the array does not contain parts of this target Sum of: " + target);
        } else {
            System.out.println("We found the following parts for the target sum: " + target + ": "+ result[0] + " and " + result[1]);
            System.out.println(result);
        }
        System.out.println("The End");
    }

    public static int[] getTwoNumSum(int[] array, Integer targetSum){
        /*
        1. Put all the numbers in the array into a set
        2. Iterate over the array
        3. At each iteration, calculate the other half = target - array[i]
        4. Check if the other half exists in the set
        5. If esits in the set then return the two numbers
        6. return empty array if iteration is complete and other half is not yet found
        EDGE CASE: make sure the other half is not not the same as array[i]
        */
        Set<Integer> set = new HashSet<>();
        for(int j=0; j<array.length; j++){
            set.add(array[j]);
        }

        int other_half=0;
        for(int i=0; i<array.length; i++){
            other_half = targetSum - array[i];
            if(set.contains(other_half) && other_half!=array[i]){
                int[] result = {array[i], other_half};
                return result;
            }
        }//for
        return new int[0];
    }


}
