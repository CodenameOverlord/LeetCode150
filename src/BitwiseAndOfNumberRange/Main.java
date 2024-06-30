package BitwiseAndOfNumberRange;

public class Main {
    public int rangeBitwiseAndSol1(int left, int right) {
        int shift = 0;
        while(left!=right){
            left = left>>1; right = right>>1; shift++;
        }
        return left<<shift;
    }


    public int rangeBitwiseAndSol2(int left, int right) {
        while(right>left){
            right=(right&(right-1));
        }
        return right;
    }
}
