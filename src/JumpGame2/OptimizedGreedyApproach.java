package JumpGame2;

public class OptimizedGreedyApproach {
    public static void main(String[] args) {
        System.out.println(jump(new int [] {2,3,1,1,4}));
    }
    public static int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int coverage = 0;
        int destination = nums.length-1;
        int jumpsMade = 0;
        int lastJumpIndex = 0;
        for(int i = 0; i< nums.length; ++i){
            coverage = Math.max(coverage, i+nums[i]);
            if(coverage>=destination){
                jumpsMade++;
                break;
            }
            if(i==lastJumpIndex){
                jumpsMade++;
                lastJumpIndex = coverage;
            }
        }
        return jumpsMade;
    }
}
