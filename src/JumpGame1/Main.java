package JumpGame1;

public class Main {
    public static void main(String[] args) {
        System.out.println(canJump(new int [] {1,1,2,1,5,1}));
        System.out.println(canJump(new int [] {1,1,2,1,0,1}));
    }
    public static boolean canJump(int[] nums) {
        if(nums.length==1 || (nums.length == 2 && nums[0]>=1) || nums.length<nums[0]){
            return true;
        }
        if(nums[0]==0){
            return false;
        }
        int eI = nums.length-2;
        int toReach = 1;
        while(eI!=0){
            if(nums[eI]>=toReach){
                toReach=1;
                eI--;
            }else{
                toReach+=1;
                eI--;
            }
        }

        if(nums[eI]>=toReach)
            return true;
        else
            return false;
    }
}
