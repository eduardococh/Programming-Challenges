		//Solution by leetcode's jocelynayoga
		//Recursive approach, could be iterative too i think
		//Decreasing n by dividing by 2. After we get the return result, multiply by itself.
		//If n is a odd number, multiply one x if n is position; otherwise, 1 / x.
class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
	//If n is negative
        if(n<0){
            return 1/x * myPow(1/x, -(n + 1));
        }
	//if n is positive
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}