import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public static void main(String[] str){
        int[] array = {8, 10, -2, 49, 14};
        int targetSum = 57;
        threeNumberSum(array, targetSum);
        System.out.println("The End");
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        int left = 1;
        int right = array.length-1;
        int runner = 0;
        int leftValue = 0;
        int rightValue = 0;
        int sum = 0;
        List<Integer[]> result = new ArrayList<>();
        Integer[] triplet = new Integer[3];
        for(int i=0; i<array.length; i++){
            runner = array[i];
            left = i+1;
            right = array.length-1;
            while(left<array.length && array[left]<array[right]){
                leftValue = array[left];
                rightValue = array[right];
                sum = runner + leftValue + rightValue;
                if(sum==targetSum){
                    triplet[0] = runner;
                    triplet[1] = leftValue;
                    triplet[2] = rightValue;
                    result.add(triplet);
                    triplet = new Integer[3];
                    left++;
                    right--;
                }else if(sum<targetSum){
                    left++;
                }else if(sum>targetSum){
                    right--;
                }else{
                    left++;
                    right--;
                }

            }//while
        }//for
        return result;
    }


}
