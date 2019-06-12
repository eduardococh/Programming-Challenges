		//My solution
		//Just multiply buy two until bigger
		//All approaches run in 1ms
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<1) return false;
        if(n==1) return true;
        double calc=1;
        while(calc<n){
            calc*=2;
            if(calc==n){
                return true;
            }
        }
        return false;
    }
}

		//My approach with a more elegant coding (long not needed)
class Solution {
    public boolean isPowerOfTwo(int n) {
        long i = 1;
        while(i < n){
            i *= 2;
        }
        
        return i == n;
        
    }
}



		//Clever solution, using and of (n, n-1) which only works for powers of two
		//8 -> 1000
		//7 -> 0111
class Solution {
	public boolean isPowerOfTwo(int n) {
		return (n > 0 && (n & (n - 1)) == 0);
	}
}