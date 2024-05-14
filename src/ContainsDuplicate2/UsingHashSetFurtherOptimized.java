package ContainsDuplicate2;

import java.util.HashSet;

public class UsingHashSetFurtherOptimized {
//    the idea is that the hashSet will have a size of k and we will remove the element of index i-k+1 where
//    i is the current element

    public static void main(String[] args) {
        containsNearbyDuplicate(new int [] {1,2,3,1,2,3}, 2);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hSet = new HashSet<>();
        int j = 0;
        for(int i =0; i< nums.length; ++i){
            int currElement = nums[i];
            if(hSet.contains(currElement)){
                return true;
            }
            hSet.add(currElement);

            if(hSet.size()>=k+1){
                hSet.remove(nums[j]);
                j++;
            }
        }

        return false;
    }
}
