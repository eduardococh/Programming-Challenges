class Solution {
	//SOlucion mayo 2018
public int maxProfit(int[] prices) {
        int mayor=0,menor=Integer.MAX_VALUE, max=0;
        for(int x=0;x<prices.length;x++){
            if(prices[x]<menor){
                menor=prices[x];
                for(int y=x+1;y<prices.length;y++){
                    if(prices[y]>=menor){
                        if(prices[y]-menor>max){
                            max=prices[y]-menor;   
                        }
                    }else{
                        x=y-1;
                        break;
                    }
                }
            }
        }
        return max;
    }
	//solucion marzo 2019, like the leetcode solution
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int max=prices[0];
        int currentMin=prices[0];
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<currentMin){
                currentMin=prices[i];             
            }
            if(prices[i]-currentMin>maxProfit){
                maxProfit=prices[i]-currentMin;
            }
        }
	return maxProfit;
    }
}