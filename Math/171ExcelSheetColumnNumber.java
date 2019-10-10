		
        //My 2nd try solution
        //Amazing runtime of 1ms faster than 99.98% O(S)
        //Amazing memory better than 100% O(1)
        //Using potence is easier to remember than leetcode's approach of multiply and add
        //in my opinion, as the natural numbers work by potence
class Solution {
    public int titleToNumber(String s) {
        int base=0;
        int result=0;
        for(int i=s.length()-1;i>=0;i--){
            result+=(s.charAt(i)-64)*((int)Math.pow(26,base++));
        }
        return result;
    }
}


        //My original solution
		//Runtime of 1ms better than 99.92% o(N) (couldn't get the 0ms sample)
		//Memory of 34.7 mb but this measure is tricky, O(1)
class Solution {
    public int titleToNumber(String s) {

        int result=0,potence=1;
        for(int i=s.length()-1;i>=0;i--){
            int relativeVal=s.charAt(i)-'A'+1;
            result+=relativeVal*potence;
            potence=potence*26;
        }
        return result;
    }
}

		//Small improvement, from leetcode 100% memory
		//Dont use potence, just multiply by 26
class Solution {
    public int titleToNumber(String s) {
        
        int sum = 0;
        for(int i = 0;i<s.length();i++)
        {
            sum = sum *26;
            sum += (int)(s.charAt(i)-'A')+1;
            
        }
        return sum;
        
    }
}