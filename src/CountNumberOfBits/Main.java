package CountNumberOfBits;

public class Main {
    public static void main(String[] args) {
        System.out.println(hammingWeight(5));
    }

    public static int hammingWeight(int n) {
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
