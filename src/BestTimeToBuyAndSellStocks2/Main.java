package BestTimeToBuyAndSellStocks2;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        /*
        * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
        * On each day, you may decide to buy and/or sell the stock.
        * You can only hold at most one share of the stock at any time.
        * However, you can buy it then immediately sell it on the same day.
        * Find and return the maximum profit you can achieve.
        * */

        /*
        * Since we can buy and sell each stock at the same day, we can use greedy approach.
        * If any day, we get maxDiff between current day and prev day >0 we are adding that and selling the stocks
        * 7  1  5   3   6   4
        * we see that we can buy the stock on value 1 at second day and sell it on 5 to make ans +=4
        * and buy again at 4th day at value 3 to sell it on 5th day at value 6 to make ans +=3
        * hence total ans = 4+3 = 7
        * */
        System.out.println(
        maxProfit(new int [] {7,6,4,3,1}));
        System.out.println(
                maxProfit(new int [] {7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        for(int i =1; i< prices.length; ++i){
            int diff = prices[i]-prices[i-1];
            max = diff>0?max+diff:max;

        }
        return max;
    }
}
