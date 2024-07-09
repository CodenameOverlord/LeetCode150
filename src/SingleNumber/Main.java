package SingleNumber;

public class Main {
    public int singleNumber(int[] nums) {
        int i =0;
        for(int j = 0; j< nums.length; j++){
            i=i^nums[j];
        }

        return i;
    }
}
