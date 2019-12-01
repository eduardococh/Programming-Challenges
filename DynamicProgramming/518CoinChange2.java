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