package JumpGame2;

public class Main {
    public static void main(String[] args) {
        System.out.println(jump(new int []{2,3,0,1,4}));
    }
    public static int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int [] minToReach = new int [nums.length];
        int n = nums.length-1;
        for(int i = n; i>=0; --i){
            if(nums[i] >= n-i){
                minToReach[i]=1;
            }
            else{
                int jumpVal = nums[i];
                int minVal = Integer.MAX_VALUE;
                for(int j =i+1; j<=i+jumpVal;++j){
                    if(minToReach[j]!=Integer.MAX_VALUE)
                        minVal = Math.min(minVal, minToReach[j]+1);
                }
                // if(minVal != Integer.MAX_VALUE)
                minToReach[i]= minVal;
            }
        }
        return minToReach[0];
    }
}
