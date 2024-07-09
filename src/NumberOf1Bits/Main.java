package NumberOf1Bits;

public class Main {
    public int hammingWeight(int n) {
        int x = 1;
        int count = 0;
        while(n>0){
            if((x & n) !=0){
                count++;
            }
            n=n>>1;
        }
        return count;
    }
}
