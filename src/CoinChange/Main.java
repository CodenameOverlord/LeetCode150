package CoinChange;

public class Main {

    public static void main(String[] args) {
        System.out.println(coinChange(new int []{2},3));
    }
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        int []dp = new int [amount+1];

        for(int i=0; i< coins.length;++i){
            if(coins[i]<amount+1){
                dp[coins[i]]=1;
            }
        }
        for(int i = 0; i< dp.length;++i){
            if(dp[i]!=1)
                dp[i]=-2;
        }
        return solve(dp, amount, coins);
    }


    static int solve(int [] dp, int amount, int [] coins){
        if(dp[amount]!=-2)
            return dp[amount];
        int currMin = Integer.MAX_VALUE;
        for(int i=0; i< coins.length; ++i){
            if(amount-coins[i]>=0){
                int prevVal = solve(dp, amount-coins[i], coins);
                if(prevVal!=-1)
                    currMin = Math.min(currMin, 1+prevVal);

            }
        }
        dp[amount]= currMin==Integer.MAX_VALUE?-1:currMin;
        return dp[amount];
    }
}
