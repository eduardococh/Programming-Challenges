        //My brute force approach
        //Based on "expand from the center"
        //Amazing runtime 1ms better than 99.97% O(N^2)
        //Amazing memory better than 100% O(1)
        //A good runtime (must be because of small test cases) but the algorithm
        //is brute force, so for every character it will expand from the center, checking for
        //odd combinations where the character is at the center and for pair combinations
        //where the number expands to the left
class Solution {
    public int countSubstrings(String s) {
        int res=0;
        int len=s.length();
        res+=len;
        for(int i=0;i<len;i++){
            res+=countPalindromes(i,s);
        }
        return res;
    }
    
    private int countPalindromes(int index,String s){
        int res=0;
        int li=index,hi=index+1;
        int len=s.length();
        boolean pair=true,odd=true;
        while(li>=0 && hi<len){
            //pair check
            if(pair){
                if(s.charAt(li)==s.charAt(hi)){
                    res++;
                }else{
                    pair=false; 
                }
            }
            li--;
            
            if(li<0) break;
            
            if(odd){
                //odd check
                if(s.charAt(li)==s.charAt(hi)){
                    res++;
                }else{
                    odd=false;
                }
            }
            hi++;
            if(!pair && !odd) break;
        }
        return res;
    }
}

        //Simpler and eleganter expand from the center solution 
        //from leetcode's 1ms samples
        //Trick is using a simple count palindrome method
        //which is called twice for every character, once to count for the center at character
        //and once to count center character and the one to their 
        //Same runtime and memory as my solution but super elegant
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i+1);
        }
        return count;
    }
    
    public int countPalindrome(String s, int left, int right) {
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}


        //Manacher algorithm's by leetcode
        //Same runtime as my solution and memory
        //Should perform better with bigger test cases
        //TO BE STUDIED IN THE FUTURE
class Solution {
    public int countSubstrings(String S) {
        char[] A = new char[2 * S.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c: S.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }

        int[] Z = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; ++i) {
            if (i < right)
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1])
                Z[i]++;
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int ans = 0;
        for (int v: Z) ans += (v + 1) / 2;
        return ans;
    }
}