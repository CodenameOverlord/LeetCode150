package TwoSumInputArrayIsSorted;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1,2,3,4,5,6,7,8,9}, 15)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0; int end = numbers.length-1;
        while(start<end){
            if(numbers[start]+numbers[end]==target){
                return new int [] {start+1, end+1};
            }
            else if(numbers[start]+numbers[end]>target){
                end--;
            }
            else{
                start++;
            }
        }

        return null;
    }
}
