package ContainsDuplicate2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        containsNearbyDuplicate(new int [] {1,2,3,1,2,3}, 2 );
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length && j<=i+k;j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
