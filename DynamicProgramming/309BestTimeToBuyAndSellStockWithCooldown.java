        //Working solution from leetcode's 1ms sample
class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length == 0) return 0;
        int n = prices.length;
        int[] buy = new int[n+1];
        int[] sell = new int[n+1];
        buy[1] = -prices[0];
        
        /* day i 
            buy 1. do nothing buy[i-1]
                2. buy after sell, becuase of cooldown, sell[i-2]-prices[i] the current profix
                max(1,2)
            sell 1. do nothing sell[i-1]
                 2. buy after sell, prices[i]+buy[i-1] since buy is negative
                max(1,2)
                 
            buy[i] = max(sell[i-2]-price, buy[i-1])
            sell[i] = max(buy[i-1]+price, sell[i-1])
        */
        for(int i =2;i<n+1;i++){
            buy[i] = Math.max(sell[i-2]-prices[i-1], buy[i-1]);
            sell[i] = Math.max(buy[i-1]+prices[i-1], sell[i-1]);
        }
        return sell[n];
    }
}