//initial brute force approach
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        for(int i=getMin(piles);i<=getMax(piles);i++){
            if(validateK(piles,h,i)) return i;
        }
        return 0;
    }
    
    public boolean validateK(int piles[],int h,int candidateK){
        for(int pile:piles){
            h-=pile/candidateK;
        }
        if(h>=0){
            return true;
        }else{
            return false;
        }
    }
    
    public int getMin(int[] piles){
        int min=Integer.MAX_VALUE;
        for(int pile:piles){
            if(pile<min){
                min=pile;
            }
        }
        return min;
    }
    
    public int getMax(int[] piles){
        int max=0;
        for(int pile:piles){
            if(pile<max){
                max=pile;
            }
        }
        return max;
    }
}