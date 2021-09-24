//My solution
//Runtime O(N)
//Memory O(1)
class Solution {
    public String breakPalindrome(String palindrome) {
        final int len=palindrome.length();
        if(palindrome==null || len<=1) return "";
        char middle='0';
        if(palindrome.length()%2!=0){//odd number
            middle=palindrome.charAt(len/2);
            palindrome=palindrome.substring(0,len/2)+palindrome.substring((len/2)+1,len);
        }
        int notAnAIndex=-1;
        for(int i=0;i<palindrome.length();i++){
            if(palindrome.charAt(i)>'a'){
                notAnAIndex=i;
                break;
            }
        }
        if(notAnAIndex>-1){//we found a solution
            palindrome=
                palindrome.substring(0,notAnAIndex)+'a'+palindrome.substring(notAnAIndex+1,palindrome.length());
            return putMiddleOrReturnUnchanged(middle,palindrome);
        }else{
            //we have only a's,replace the last position with a 'b'
            palindrome=palindrome.substring(0,palindrome.length()-1)+'b';
            return putMiddleOrReturnUnchanged(middle,palindrome);
        }
    }
    
    public String putMiddleOrReturnUnchanged(char middle,String palindrome){
        if(middle=='0') return palindrome;
        return palindrome.substring(0,palindrome.length()/2)+middle+palindrome.substring(palindrome.length()/2,palindrome.length());
    }
}