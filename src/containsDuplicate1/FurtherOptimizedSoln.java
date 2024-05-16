package containsDuplicate1;

public class FurtherOptimizedSoln {
    public static void main(String[] args) {

    }
    public int removeDuplicates(int[] nums) {
        int currElement = -101;
        int currPtr = 0;
        int k = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != currElement){
                nums[currPtr] = nums[i];
                currPtr++;
                k++;
                currElement = nums[i];
            }
        }
        return k;
    }

}
