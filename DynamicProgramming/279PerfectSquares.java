class Solution {
    public int numSquares(int n) {
        if(n==1) return 1;
        List<Integer> perfectSquares=new ArrayList<Integer>();
        int i=1;
        while(i*i<=n){
            //System.out.println("add "+i*i);
            perfectSquares.add(i*i);
            i++;
        }
        int numOfPS=perfectSquares.size();
        int dp[]=new int[n+1];
        for(i=1;i<=n;i++){
            int psIndex=0;
            int currentCoin=perfectSquares.get(0);
            int smallestCoinN=Integer.MAX_VALUE;
            while(i-currentCoin>=0 && psIndex<numOfPS){
                //System.out.println("we try "+currentCoin+" "+dp[i-currentCoin]);
                if(dp[i-currentCoin]+1<smallestCoinN){
                    //System.out.println(currentCoin+" is smallest");
                    dp[i]=dp[i-currentCoin]+1;
                    smallestCoinN=dp[i];
                }
                psIndex++;
                if(psIndex==numOfPS) break;
                currentCoin=perfectSquares.get(psIndex);
            }
            //System.out.println("dp in "+i+" is "+dp[i]);
        }
        return dp[n];
    }
}