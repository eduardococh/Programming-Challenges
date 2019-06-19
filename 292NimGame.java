		//My complex solution
		//0ms good runtime
		//not worth looking
class Solution {
    public boolean canWinNim(int n) {
        n=Math.abs(n);
        if(n==0) return false;
        if(n<3) return true;
        if((n-2)%4==0) return true;
        n=n-3;
        if(n%2==0){
            return true;
        }else{
            return false;
        }
    }
}

		//From leetcode's better than 100% in memory
		//Simple rule followed here
class Solution {
    public boolean canWinNim(int n) {
        if(n % 4 == 0) return false;
        return true;
    }
}