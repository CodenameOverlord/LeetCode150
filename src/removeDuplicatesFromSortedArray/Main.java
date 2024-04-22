package removeDuplicatesFromSortedArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] arr = {1,2,4,4,4,5,6};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {
        int curr = 0; int next = 1;
        //check nums size
        if(nums.length<2){
            return 1;
        }
        //traverse till next hits last element
        boolean flag = true;
        while(next<nums.length){
            if(nums[next] == nums[curr]){
                flag = false;
                while(next<nums.length && nums[next]== nums[curr]){
                    next++;
                }
                if(next<nums.length){
                    curr++;
                    nums[curr]= nums[next];
                    next++;
                }
            }
            else{
                if(flag){
                    curr++; next++;
                }
                else{
                    curr++;
                    nums[curr]= nums[next]; next++;
                }
            }

        }

        Arrays.stream(nums).forEach(t-> System.out.print(t+" "));
        //number of distinct elements = curr+1;
        return curr+1;
    }
}
