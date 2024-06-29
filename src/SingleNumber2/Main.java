package SingleNumber2;

public class Main {

    public int singleNumber(int[] nums) {
        int ans = 0;
        int curr = 1;
        int pos = 0;

        while(pos<32){
            int numSet = 0;
            for(int i =0; i<nums.length;++i){
                if((nums[i]&curr)!=0){
                    numSet++;
                }
            }
            if(numSet%3!=0){
                ans|=curr;
            }
            curr = curr<<1; pos++;
        }

        return ans;
    }
}
