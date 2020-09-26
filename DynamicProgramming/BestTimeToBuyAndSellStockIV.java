        //My "brute force" solution
        //Its not really brute force but it was the simplest I could think of
        //Runtime 11ms better than 23.42% O(N^2) where N is the number of trades
        //Memory better than 73.55% O(N)
class Solution {
    public int maxProfit(int k, int[] prices) {
        List<Integer[]> tradesList=getTradesList(prices);
        return optimizeTrades(tradesList,k,prices);
    }
    
    public int optimizeTrades(List<Integer[]> tradesList,int k,int[] prices){
        while(tradesList.size()>k){

            //try to combine trades to minimize losses
            int minLoss=Integer.MAX_VALUE;
            int mergeIndex=-1;
            for(int i=0;i<tradesList.size()-1;i++){
                Integer currentTrade[]=tradesList.get(i);
                Integer nextTrade[]=tradesList.get(i+1);
                int currentValue=(prices[nextTrade[1]]-prices[nextTrade[0]])+(prices[currentTrade[1]]-prices[currentTrade[0]]);
                int mergeValue=(prices[nextTrade[1]]-prices[currentTrade[0]]);
                int netLoss=currentValue-mergeValue;
                if(netLoss<minLoss){
                    mergeIndex=i;
                    minLoss=netLoss;
                }
            }
            //verify if we would be better just deleting a trade, and not merging
            //if no merge with bigger profits if possible, just drop the lowest value trade
            int lowestValueTrade=Integer.MAX_VALUE;
            int deleteIndex=-1;
            for(int i=0;i<tradesList.size();i++){
                int currentTrade=prices[tradesList.get(i)[1]]-prices[tradesList.get(i)[0]];
                if(currentTrade<minLoss){
                    minLoss=currentTrade;
                    deleteIndex=i;
                }
            }
            if(deleteIndex!=-1){
                tradesList.remove(deleteIndex);	
            }else{
                tradesList.set(mergeIndex,new Integer[] {tradesList.get(mergeIndex)[0],tradesList.get(mergeIndex+1)[1]});
                tradesList.remove(mergeIndex+1);			
            }		

        }
        return getTotalProfit(tradesList,prices);
    }

    public int getTotalProfit(List<Integer[]> tradesList,int[] prices){
        int totalProfit=0;
        for(Integer[] trade:tradesList){
            totalProfit+=prices[trade[1]]-prices[trade[0]];
        }
        return totalProfit;
    }

    public static List<Integer[]> getTradesList(int[] prices){
        final int len=prices.length;
        List<Integer[]> transactions=new ArrayList<Integer[]>();
        int i=0;
        while(i<len-1){
            int buyIndex,sellIndex;
            while(i<len-1 && prices[i]>=prices[i+1]){
                i++;
            }
            if(i==len-1) break;//len-2 and len-1 are downprices
            buyIndex=i;
            //if i enter this loop im at least at i-2 and know that i-1 is bigger than me
            //so we ensure that there's a possible trade
            while(i<len-1 && prices[i]<prices[i+1]){
                i++;
            }
            sellIndex=i;//I know that i will be bigger than buy index
            //because the first loop guarantees that, the second loop only
            //searches for the biggest one in the sequence
            //System.out.println("we add "+buyIndex+" "+sellIndex);
            transactions.add(new Integer[]{buyIndex,sellIndex});
            i++;
        }
        return transactions;
    }
}