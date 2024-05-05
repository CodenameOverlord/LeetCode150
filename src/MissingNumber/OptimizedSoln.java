package MissingNumber;

public class OptimizedSoln {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int [] {9,6,4,2,3,5,7,0,1}));
    }

    private static int missingNumber(int[] nums) {
        long ans = 0;
        for(int i =0; i< nums.length;++i){
            ans+=nums[i];
        }
        long n = nums.length;
        ans = n*(n+1)/2-ans;
        return (int)ans;
    }

}
