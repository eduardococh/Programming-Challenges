		//My dp code, memory limit excedeed
		//i had a more brute force solution which would take o(n^3)
		//simple basic logic but not good enough as the good dp solutions
		//BAD CODE, DOES NOT SOLVE IT
class Solution {
    public String longestPalindrome(String s) {
        String longest="";
        Set<String> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String currentSubStr=s.substring(i,j);
                if(!set.contains(currentSubStr)){
                    set.add(currentSubStr);
                    if(isPalindrome(currentSubStr)){
                        if(currentSubStr.length()>longest.length()){
                            longest=currentSubStr;
                        }
                    }
                    
                }
            }
        }
        return longest;
    }
    
    public boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
}

		//my preferred approach
		//Leetcode's expand around center solution
		//Brilliant, no need of extra strings or anything
		//Good runtime at 6 ms better than 88.82% and o(n^2) since we check palindrome 2 times per
		//every n letter and every check takes at most n
		//Amazing memory better than 99.98% O(1)

public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
}

		//Manacher algorithm is another suggested solution, but it is not trivial, 
		//you're not supposed to come up with this in a 45 minutes interview


		//DP solution by leetcode's jeantimex 
		//very interesting, not as simple as mine (like this code is simpler, but not so
		//obvious to come up with)
		//Runtime of 54ms faster than only 30.30% 
		//bad memory better than only 26.44%


class Solution {
    public String longestPalindrome(String s) {
      if(s.length()==0) return "";
      int n = s.length();
      String res = null;

      boolean[][] dp = new boolean[n][n];

      for (int i = n - 1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
		//if the outer i (left) and j (right) are equal and the string inside i and j is palindromic or j-i is smaller than 3 
          dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

          if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
            res = s.substring(i, j + 1);
          }
        }
      }

      return res;
    }
}