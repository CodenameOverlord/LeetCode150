package MajorityElement;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int arr [] = new int [] {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));


    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> hMap = new HashMap<>();
        for(int i =0; i< nums.length; ++i){
            if(hMap.containsKey(nums[i])){
                hMap.put(nums[i], hMap.get(nums[i])+1);
            }
            else{
                hMap.put(nums[i],1);
            }
        }
        int ans = -1; int freq=0;
        for(int key:hMap.keySet()){
            if(freq<hMap.get(key)){
                ans = key;
                freq= hMap.get(key);
            }
        }
        return ans;

    }
}
