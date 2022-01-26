//LESSONS
//Careful with integer divisions, here candidateK needed to be double
//otherwise division is truncated before it can be used by math ceil
//

//Solution based on leetcode's linfq
//Average runtime better than 38% O(Log N)
//Good memory better than 71% O(1)
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int low = 1, high = 1000000000, k = 0;
        while (low <= high) {
            k = (low + high) / 2;
            int hoursToEat = 0;
            for (int i = 0; i < piles.length; i ++) {
                hoursToEat += Math.ceil(1.0 * piles[i] / k);
            }
            if (hoursToEat > H){//this speed is too slow, we need faster
                low = k + 1;
            }else{//good speed, try to find a faster speed
                high = k - 1;
            }
        }
        return low;
    }
}

//My binary search solution, a lot of extra code, can be improved
//Bad runtime O(Log N) 75ms better than only 5% where N is space from 1 to max pile
//Bad memory better than only 17% O(1)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=getMax(piles);
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid==1){
                if(validateK(piles,h,mid)){
                    return 1;
                }else{
                    left=2;
                    continue;
                }
            }
            if(validateK(piles,h,mid)){//if valid, check one left 
                if(validateK(piles,h,mid-1)){//if also valid, search left
                    right=mid-1;
                }else{//if not valid, we're on the minimal
                    return mid;
                }
                
                
            }else{//if invalid, go right
                left=mid+1;
            }
        }
        return 0;
    }
    
    public boolean validateK(int piles[],int h,double candidateK){
        for(int pile:piles){
            h-=Math.ceil(pile/candidateK);
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
            if(pile>max){
                max=pile;
            }
        }
        return max;
    }
}




//Brute force solution
//iterate from 1 to max
//Rejeted time limit excedeed
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        for(int i=1;i<=getMax(piles);i++){
            if(validateK(piles,h,i)) return i;
        }
        return 0;
    }
    
    public boolean validateK(int piles[],int h,double candidateK){
        for(int pile:piles){
            h-=Math.ceil(pile/candidateK);
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
            if(pile>max){
                max=pile;
            }
        }
        return max;
    }
}