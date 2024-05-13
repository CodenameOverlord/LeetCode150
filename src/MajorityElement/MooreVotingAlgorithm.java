package MajorityElement;

import java.util.HashMap;
import java.util.Map;

public class MooreVotingAlgorithm {
    public static void main(String[] args) {
        int arr [] = new int [] {6,6,6,7,7};
        System.out.println(majorityElement(arr));


    }

    public static int majorityElement(int[] nums) {
        int lead = 0;
        int candidate = nums[0];
       for(int i = 0; i< nums.length; ++i){
           if(candidate == nums[i]){
               lead++;
           }
           else{
               lead--;
               if(lead==0){
                   lead = 0;
                   candidate = nums[i];
               }
           }
       }
       return candidate;
    }
}
