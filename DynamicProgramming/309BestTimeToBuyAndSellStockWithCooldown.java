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
        if(prices.length==0) return 0;
        StockStatus dp[]=new StockStatus[prices.length];
        dp[0]=new StockStatus(0,true);
        int smaller=prices[0];
        int smallerIndex=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<prices[i-1]){
                //we're smaller than previous there's no way to sell here
                //we MUST buy now
                //if(dp[i-1].status==false){
                    dp[i]=new StockStatus(i-2>=0?dp[i-2].maxProfit:0,true);
                    //System.out.println(i+" we put buy "+(i-2>=0?dp[i-2].maxProfit:0));
                //}else{
                    //dp[i]=new StockStatus(dp[i-1].maxProfit,true);
                //}
                smaller=prices[i];
                smallerIndex=i;
            }else{
                //we're bigger than the previous, now calculate the profit
                //from the smaller
                dp[i]=new StockStatus(dp[smallerIndex].maxProfit+prices[i]-smaller,false);
                //System.out.println(i+" we put sell "+(dp[smallerIndex].maxProfit+prices[i]-smaller));
            }
        }
        int maximum=0;
        for(int i=0;i<prices.length;i++){
            if(dp[i].maxProfit>maximum){
                maximum=dp[i].maxProfit;
            }
        }
        return maximum;
    }
}