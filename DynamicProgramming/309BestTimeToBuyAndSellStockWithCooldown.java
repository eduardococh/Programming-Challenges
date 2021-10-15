        //Working solution from leetcode's 1'ms sample
        //Using O(N) space
        //We have two arrays, they work like this

        /* For any day i
            BUY 1. We do nothing, which means we grab buy in [i-1]
                2. We buy after sell, because of cooldown, sell[i-2]-prices[i] the current profit
                we save the max between the two options
            SELL 1. Do nothing, we grab sell in [i-1]
                 2. buy after sell, prices[i]+buy[i-1] since buy is negative
                we save the max between the two options
                 
            buy[i] = max(sell[i-2]-price, buy[i-1])
            sell[i] = max(buy[i-1]+price, sell[i-1])

            EXAMPLE
            [3, 5, 4, 8, 9, 5, 6, 1, 0, 2, 8]
        BUY [0,-3,-3,-3,-3, 0, 0, 5, 6, 6, 6]
        SELL[0, 0, 2, 2, 5, 6, 6, 6, 6, 8, 14]    
        */

class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length == 0) return 0;
        int n = prices.length;
        int[] buy = new int[n+1];
        int[] sell = new int[n+1];
        buy[1] = -prices[0];
        for(int i =2;i<n+1;i++){
            buy[i] = Math.max(sell[i-2]-prices[i-1], buy[i-1]);
            sell[i] = Math.max(buy[i-1]+prices[i-1], sell[i-1]);
        }
        return sell[n];
    }
}


//Brute force solution
class Solution {
    public int maxProfit(int[] prices) {
        return maxProfit(prices,0,-1,0,false);
    }
    
    public int maxProfit(int[] prices,int index,int stock,int profit,boolean cooldown){
        if(index>=prices.length) return profit;
        if(cooldown) return maxProfit(prices,index+1,-1,profit,false);
        if(stock==-1){//we can buy
            int weBuy=maxProfit(prices,index+1,prices[index],profit,false);
            int dontBuy=maxProfit(prices,index+1,-1,profit,false);
            return Math.max(weBuy,dontBuy);
        }else{
            if(prices[index]>stock){//we can sell
                int weSell=maxProfit(prices,index+1,-1,profit+(prices[index]-stock),true);
                int weHold=maxProfit(prices,index+1,stock,profit,false);
                return Math.max(weSell,weHold);
            }else{
                return maxProfit(prices,index+1,stock,profit,false);
            }
        }
    }
}'