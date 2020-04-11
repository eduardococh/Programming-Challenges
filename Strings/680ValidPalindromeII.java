        //My solution using simple recursion (never recurses more than one level)
        //Average runtime of 7ms better than 61.27% O(N)    
        //Bad memory better than only 25% O(1)
        //Not the most elegan solution
class Solution {
    public boolean validPalindrome(String s) {
        int start=0,end=s.length()-1;
        boolean deleted=false;
        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }else{
                if(deleted) return false;
                if(validPalindromeSimple(s.substring(start+1,end+1))){
                    deleted=true;
                    start=start+2;
                    end--;
                    continue;
                }
                if(validPalindromeSimple(s.substring(start,end))){
                    deleted=true;
                    end=end-2;
                    start++;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
    
    public boolean validPalindromeSimple(String s) {
        //System.out.println("we checking "+s);
        int start=0,end=s.length()-1;
        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}

        //Same approach, but more elegant coding from leetcode's 4ms samples
        //Amazing runtime better than 100% O(N)
        //At big glance this is the same approach all good solutions have
        //check for either skipping the character at i or character at j and check if one of both is palindrome
class Solution {
    public boolean validPalindrome(String s) {
        return helper(s, true);
    }
    
    public boolean helper(String s, Boolean allow) {
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (allow) {
                    return helper(s.substring(i, j), false) || helper(s.substring(i+1, j+1), false);
                }
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}