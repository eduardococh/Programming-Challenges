class Solution {
		//My solution, vertical scanning better runtime than 92% of solutions and better memory than 12.21 
		//runtime of o(n*l) n=number of strings and l=length of prefix, in leetcode they express it like s
		//which is the total count of characters in all strings, which in worse case its true o(s)
		//My solution is vertical scanning, theres horizontal scanning too and both have same runtime
		//Theres a divide and conquer approach but it takes same runtime o(S), but with best case scenarios
		//it behaves well
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        int minLength=Integer.MAX_VALUE;
        for(String str:strs){
            if(str.length()<minLength){
                minLength=str.length();
            }
        }
        String prefix="";
        for(int i=0;i<minLength;i++){
            char currentChar=strs[0].charAt(i);
            for(String str:strs){
                if(str.charAt(i)!=currentChar){
                    return prefix;
                }
            }
            prefix=prefix+currentChar;
        }
        return prefix;
    }
}

//Divide and conquer approach, not the best
public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";    
        return longestCommonPrefix(strs, 0 , strs.length - 1);
}

private String longestCommonPrefix(String[] strs, int l, int r) {
    if (l == r) {
        return strs[l];
    }
    else {
        int mid = (l + r)/2;
        String lcpLeft =   longestCommonPrefix(strs, l , mid);
        String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
        return commonPrefix(lcpLeft, lcpRight);
   }
}

String commonPrefix(String left,String right) {
    int min = Math.min(left.length(), right.length());       
    for (int i = 0; i < min; i++) {
        if ( left.charAt(i) != right.charAt(i) )
            return left.substring(0, i);
    }
    return left.substring(0, min);
}

//Binary search, best runtime at o(S*log(n)) where SS is the sum of all characters in all strings.
//The algorithm makes log(n)iterations, for each of them there are S = m*n comparisons, 
//which gives in total O(S*log(n)) time complexity.
public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0)
        return "";
    int minLen = Integer.MAX_VALUE;
    for (String str : strs)
        minLen = Math.min(minLen, str.length());
    int low = 1;
    int high = minLen;
    while (low <= high) {
        int middle = (low + high) / 2;
        if (isCommonPrefix(strs, middle))
            low = middle + 1;
        else
            high = middle - 1;
    }
    return strs[0].substring(0, (low + high) / 2);
}

private boolean isCommonPrefix(String[] strs, int len){
    String str1 = strs[0].substring(0,len);
    for (int i = 1; i < strs.length; i++)
        if (!strs[i].startsWith(str1))
            return false;
    return true;
}

//Trie approach, for the next round on this problem
