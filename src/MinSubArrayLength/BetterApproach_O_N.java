package MinSubArrayLength;

public class BetterApproach_O_N {

    public static void main(String[] args) {

        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
//https://leetcode.com/problems/minimum-size-subarray-sum/solutions/4471335/easy-java-solution/
    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0; int j = 0;
        int currSum = 0;
        int currMinIndex = Integer.MAX_VALUE;
        while(i<nums.length){
            while(j<nums.length && currSum< target){
                currSum+= nums[j];
                j++;
            }

            if(currSum>=target){
                currMinIndex = Math.min(currMinIndex, j-i);
            }

            currSum = currSum- nums[i];
            i++;

        }

        return currMinIndex==Integer.MAX_VALUE?0:currMinIndex;

    }

}
