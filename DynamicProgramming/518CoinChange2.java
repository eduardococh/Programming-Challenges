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
        
    }
}