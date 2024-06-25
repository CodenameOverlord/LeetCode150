package ReverseBits;

public class Main {

    public int reverseBits(int n) {
        int ans = 0;
        boolean flag = false;
        if((n & (1<<31))!=0)
            flag = true;
        for(int i =31; i>=0; --i){
            int currNum = 1<<i;
            if((currNum & n )>0){
                ans+=(1<<(31-i));
            }
        }
        if(flag){
            ans+=1;
        }
        return ans;
    }

}
