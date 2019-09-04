class Solution {
    
    class StockStatus{
        int maxProfit;
        boolean status;//true-buy false-sell
        
        public StockStatus(int maxProfit,boolean status){
            this.maxProfit=maxProfit;
            this.status=status; 
        }
    }
    
    public int maxProfit(int[] prices) {
        StockStatus dp[]=new StockStatus[prices.length+1];
        dp[0]=new StockStatus(prices[0],true);
        for(int i=0;i<prices;i++){
            if(prices[i]<prices[i-1])
        }
    }
}