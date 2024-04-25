package MinSubArrayLength;

public class Main {
    public static void main(String[] args) {

        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int [] prefixSum = new int [nums.length];
        prefixSum[0]=nums[0];
        for(int i = 1; i<prefixSum.length; ++i ){
            prefixSum[i]= prefixSum[i-1]+nums[i];
        }
        int current = Integer.MAX_VALUE;
        for(int i =0; i<prefixSum.length;++i){
            if(prefixSum[i]>=target){
                current = Math.min(current, i+1);
            }
        }
        for(int i = 0; i<prefixSum.length; ++i){
            for(int j = i+1; j< prefixSum.length; ++j){
                if(prefixSum[j]-prefixSum[i]>=target){
                    current = Math.min(current, j-i);
                }
            }
        }

        return current==Integer.MAX_VALUE?0:current;

    }
}
