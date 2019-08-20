        //My solution
        //A brute force where you count from 1+2+3...
        //Simple approach and it works
        //Bad runtime at 8ms better than 32.44% o(n)? O(log(n))?
        //The optimal solutions all need some math that is not trivial
        //So I think this approach is OK but in an interview should be improved
class Solution {
    public int arrangeCoins(int n) {
        long stair=1,i=0;
        while(i<n){
            i+=stair;
            stair++;
        } 
        stair--;
        if(i==n) return (int)stair;
        return (int)stair-1;
    }
}


        //Binary search with a twisted formula
        //From leetcode's larrywang2014 and explanation by leetcode's ratchapongt
        //Interesting approach, some math needed to get formula
public int arrangeCoins(int n) {   
        //convert int to long to prevent integer overflow
        long nLong = (long)n;
        
        long st = 0;
        long ed = nLong;
        
        long mid = 0;
        
        while (st <= ed){
            mid = st + (ed - st) / 2;
            
            if (mid * (mid + 1) <= 2 * nLong){
                st = mid + 1;
            }else{
                ed = mid - 1;
            }
        }
        
        return (int)(st - 1);
    }

        //Simplest fastest solution from leetcode's 1ms samples
        //Better than 100% O(1)
        //Interesting math, not so trivial for an interview
class Solution {
    public int arrangeCoins(int n) {
                return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
}