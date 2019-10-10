		//Solution by leetcode's WHERE_AM_I
        //AMAZING logic, using the mapping A->1 Z->26 just complicates things
        //instead of that just define A->0 Z->25, this makes things a lot easier
        //so for all calculus just use n-1 for all calculus
        //Amazing runtime better than 100% O(N)
        //Amazing memory better than 100% O(1)
public class Solution {
    public String convertToTitle(int n) {
        String res = "";
        while(n != 0) {
            char ch = (char)((n - 1) % 26 + 65);
            n = (n - 1) / 26;
            res = ch + res;
        }
        return res;
    }
}
        
        //My solution, better than 100%
		//Memory better than 100%
		//Simple problem but tricky, because it's not like normal numeric systems
		//dividing by 26 wont work because every 26 digits you add 1
class Solution {
    public String convertToTitle(int n) {
        StringBuilder result=new StringBuilder("");
        while(n>0){
            if(n%26==0){
                result.insert(0,'Z');
                n--;
            }else{
                result.insert(0,(char)(n%26+64));
            }
            n=n/26;
        }
        return result.toString();
    }
}