package LongestConsecutiveInteger;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int [] {1,2,4,5,6,8,9,9,9,9,0}));
    }
    public static int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int op = 1; int counter = 1;
        for(int i =1; i< nums.length; ++i){
            while(i<nums.length && (nums[i]==nums[i-1] || nums[i]==nums[i-1]+1)){
                if(nums[i]==nums[i-1]){
                    i++;
                    continue;
                }
                counter++;
                i++;
                op = Math.max(op, counter);
            }
            counter = 1;
        }
        return op;
    }
}
