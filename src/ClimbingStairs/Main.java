package ClimbingStairs;

public class Main {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
    public static int climbStairs(int n) {
        int dp[] = new int [n+1];
        dp[0]=1; dp[1]=1;
        return fibo(dp, n);
    }
    static int fibo(int [] dp, int n){

        if(dp[n]==0){
            dp[n]= fibo(dp, n-1)+fibo(dp, n-2);
        }
        return dp[n];
    }

}
