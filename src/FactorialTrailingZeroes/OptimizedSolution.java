package FactorialTrailingZeroes;

public class OptimizedSolution {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }

    public static int trailingZeroes(int n) {
        int ans = 0;
        for(int i =5; i<n; i=i*5 ){
            ans+=n/i;
        }

        return ans;

    }
}
