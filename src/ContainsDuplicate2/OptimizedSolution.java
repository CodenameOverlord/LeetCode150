package ContainsDuplicate2;

import java.util.HashMap;
import java.util.Map;

public class OptimizedSolution {
    public static void main(String[] args) {
        containsNearbyDuplicate(new int []{1,2,3,1,2,3},2);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hMap = new HashMap<>();
        for(int i =0; i< nums.length; ++i){
            int currElement = nums[i];
            if(hMap.containsKey(currElement)){
                if(i-hMap.get(currElement)<=k){
                    return true;
                }
                hMap.put(currElement, i);
            }
            else{
                hMap.put(currElement, i);
            }
        }

        return false;
    }
}
