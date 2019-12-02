class Solution {
    HashSet<ArrayList<Integer>> res;
    int nCoins[];

    public int change(int amount, int[] coins) {
        res=new HashSet<ArrayList<Integer>>();
        nCoins=new int[coins.length];
        changeHel(amount,coins);
        return res.size();
    }

    public void changeHel(int amount,int[] coins){
        if(amount==0){
            ArrayList<Integer> tuple=new ArrayList<Integer>();
            for(int coin:nCoins){
                tuple.add(coin);
            }
            if(!res.contains(tuple)) res.add(tuple);
        }
        if(amount<0) return;
        for(int i=0;i<coins.length;i++){
            nCoins[i]++;
            changeHel(amount-coins[i],coins);
            nCoins[i]--;
        }
    }
}


        //Solution by leetcode's
        //Runtime of 1ms better than 100%
        //Memory of 34.4 mb better than 100%
        //This solution is so good because it only uses a linear amount sized array
class Solution {
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int coin : coins) {
      for (int x = coin; x < amount + 1; ++x) {
        dp[x] += dp[x - coin];
      }
    }
    return dp[amount];
  }
}

        //My solution based on b2b swe video
        //Bad runtime of 8ms faster than only 27.64% O(M*N) M is amount and N num of coins
        //Bad memory of 36.6mb less than 30.23% O(M*N)
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length+1][amount+1];
        //filling the cero amount column with one's (for the subproblem of cero dollars
        //there's always one way of making it)
        for(int i=0;i<=coins.length;i++){
            dp[i][0]=1;
        }
        //row 0 will be full of 0's exept in the first position
        for(int i=1;i<=coins.length;i++){
            for(int j=0;j<=amount;j++){
                //System.out.println("we in "+i+" "+j);
                if(j>=coins[i-1]){
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}