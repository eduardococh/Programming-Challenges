class Solution {
    
    HashSet<ArrayList<Integer>> res;
    int nCoins[];
    
    public int change(int amount, int[] coins) {
        res=new HashSet<ArrayList<Integer>>();
        nCoins=new int[coins.length];
        changeHel(amount,coins);
        return res.length();
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
        for(int i=0
    }
}