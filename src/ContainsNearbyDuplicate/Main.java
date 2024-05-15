package ContainsNearbyDuplicate;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int [] {1,2,34,5,1,5},2));
    }


    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hMap = new HashMap<>();
        int j = 0;
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
            if(hMap.size()>=k+1){
                hMap.remove(nums[j++]);
            }
        }

        return false;
    }
}
