package FactorialTrailingZeroes;

public class Main {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }
    public static int trailingZeroes(int n) {
        int n5 = 0;
        int i =5;
        if(n<5)
            return 0;
        while(i<=n){
            n5+=maxPow5(i);
            i+=5;
        }
        return n5;
    }

    private static int maxPow5(int num) {
        int i =0;
        while(num>1 && num%5==0){
            num/=5;
            i++;
        }
        return i;
    }
}
