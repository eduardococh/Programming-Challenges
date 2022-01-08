//Wasn't able to figure on my own, 
//Solution based on leetcode's hi-malik explanation, just replaced one line of code to make clear (to myself)
//Runtime 1ms better than 39% O(Log N)
//Memory better than 64% O(1)
class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1; // Checking for base case
        int res = 0;
        int fac = 1; // keep for 2 basically
        
        while(n != 0){
            // first we need to check what is our bit in 2 by taking modulo
            if( n % 2 == 0 ){
                res += fac * 1;
            }else{
                res += fac * 0;
            }
            // res is the number convert back to decimal + factor * n % 2 if comes 0 then we take 1 otherwise 0 this is our complement
            
            fac *= 2;
            n /= 2;
        }
        return res;
    }
} 



//Solution using java complement (shouldn't be expected in an interview)
class Solution {
    public int bitwiseComplement(int n) {
        return n == 0 ? 1 : ((1 << Integer.toBinaryString(n).length()) - 1) ^ n;
    }
}