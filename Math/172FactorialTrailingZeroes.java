		//Explanation
/*5^1 :  4617 ÷ 5 = 923.4, so I get 923 factors of 5
  5^2 :  4617 ÷ 25 = 184.68, so I get 184 additional factors of 5
  5^3 :  4617 ÷ 125 = 36.936, so I get 36 additional factors of 5
  5^4 :  4617 ÷ 625 = 7.3872, so I get 7 additional factors of 5
  5^5 :  4617 ÷ 3125 = 1.47744, so I get 1 more factor of 5
  5^6 :  4617 ÷ 15625 = 0.295488, which is less than 1, so I stop here.
*/

		//From leetcode's 0ms solution
		//0ms better than 100%
		//Memory better than 63%
		//This is a heavy math problem
class Solution {
    public int trailingZeroes(int n) {
        int ans=0;
        while(n>0){
            ans+=n/5;
            n=n/5;
        }
        return ans;
    }
}