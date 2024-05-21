package MinSizeSubArraySum;

public class Main {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(
                15,
                new int [] {1,2,3,4,5}
        ));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int sI = 0, eI = 0, total = 0,currLen = 0, minLen = Integer.MAX_VALUE;
        int n = nums.length;
        while(eI < n){
            total = total+nums[eI];
            currLen++;
            if(total>=target){
                minLen = Math.min(minLen, currLen);
                while(sI<eI && total-nums[sI]>=target){
                    total = total- nums[sI];
                    sI++;
                    currLen--;
                    minLen = Math.min(minLen, currLen);
                }
            }
            eI++;
        }
        while(sI<eI && total-nums[sI]>=target){
            total = total- nums[sI];
            sI++;
            currLen--;
            minLen = Math.min(minLen, currLen);
        }

        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}
