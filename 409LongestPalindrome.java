		//My solution
		//Average runtime at 2ms better than 69.9%
		//Amazing memory at 34.7mb better than 99.47%
		//Good obvious solution, greedy algorithm it appears, not the clearer
		//or most elegant implementation
		//
class Solution {
    public int longestPalindrome(String s) {
        int letters[]=new int[52];
        final int length=s.length();
        int result=0;
        for(int i=0;i<length;i++){
            if(s.charAt(i)>'Z'){
                letters[s.charAt(i)-73]++; 
            }else{
                letters[s.charAt(i)-65]++;
            }
        }
        boolean none=false;
        for(int i=0;i<52;i++){
            if(!none){
                if(letters[i]%2==1){
                    result+=letters[i];
                    none=true;
                    continue;
                }
            }
            if(letters[i]%2==0){
                result+=letters[i];
            }else{
                result+=letters[i]-1;
            }
        }
        return result;
    }
}

		//Leetcode's greedy algorithm
		//Amazing runtime 1ms better than 100%
		//Amazing memory better than 99.06%
		//Clearer simpler solution than mine
class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1) //if the solution is even add 1 once, bc then it will be none
                ans++;
        }
        return ans;
    }
}