        //
class Solution {
    public boolean isMatch(String s, String p) {
    int sLen = s.length(), pLen = p.length();
    int sIdx = 0, pIdx = 0;
    int starIdx = -1, sTmpIdx = -1;

    while (sIdx < sLen) {
      // If the pattern caracter = string character
      // or pattern character = '?'
      if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))){
        ++sIdx;
        ++pIdx;
      }
      // If pattern character = '*'
      else if (pIdx < pLen && p.charAt(pIdx) == '*') {
        // Check the situation
        // when '*' matches no characters
        starIdx = pIdx;
        sTmpIdx = sIdx;
        ++pIdx;
      }
      // If pattern character != string character
      // or pattern is used up
      // and there was no '*' character in pattern 
      else if (starIdx == -1) {
        return false;
      }
      // If pattern character != string character
      // or pattern is used up
      // and there was '*' character in pattern before
      else {
        // Backtrack: check the situation
        // when '*' matches one more character
        pIdx = starIdx + 1;
        sIdx = sTmpIdx + 1;
        sTmpIdx = sIdx;
      }
    }

    // The remaining characters in the pattern should all be '*' characters
    for(int i = pIdx; i < pLen; i++)
      if (p.charAt(i) != '*') return false;
    return true;
    }
}       
        //Leetcode's solution
        //Good runtime at 6ms better than 76.67%
        //Amazing memory better than 100% 
class Solution {
  public boolean isMatch(String s, String p) {
    int sLen = s.length(), pLen = p.length();

    // base cases
    if (p.equals(s) || p.equals("*")) return true;
    if (p.isEmpty() || s.isEmpty()) return false;

    // init all matrix except [0][0] element as False
    boolean[][] d = new boolean[pLen + 1][sLen + 1];
    d[0][0] = true;

    // DP compute
    for(int pIdx = 1; pIdx < pLen + 1; pIdx++) {
      // the current character in the pattern is '*'
      if (p.charAt(pIdx - 1) == '*') {
        int sIdx = 1;
        // d[p_idx - 1][s_idx - 1] is a string-pattern match
        // on the previous step, i.e. one character before.
        // Find the first idx in string with the previous math.
        while ((!d[pIdx - 1][sIdx - 1]) && (sIdx < sLen + 1)) sIdx++;
        // If (string) matches (pattern),
        // when (string) matches (pattern)* as well
        d[pIdx][sIdx - 1] = d[pIdx - 1][sIdx - 1];
        // If (string) matches (pattern),
        // when (string)(whatever_characters) matches (pattern)* as well
        while (sIdx < sLen + 1) d[pIdx][sIdx++] = true;
      }
      // the current character in the pattern is '?'
      else if (p.charAt(pIdx - 1) == '?') {
        for(int sIdx = 1; sIdx < sLen + 1; sIdx++)
          d[pIdx][sIdx] = d[pIdx - 1][sIdx - 1];
      }
      // the current character in the pattern is not '*' or '?'
      else {
        for(int sIdx = 1; sIdx < sLen + 1; sIdx++) {
          // Match is possible if there is a previous match
          // and current characters are the same
          d[pIdx][sIdx] = d[pIdx - 1][sIdx - 1] &&
                  (p.charAt(pIdx - 1) == s.charAt(sIdx - 1));
        }
      }
    }
    return d[pLen][sLen];
  }
}

        //My Solution
        //Works but time limit exceeded
        //A way to memoitize or add dp into it should work
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length()==1 && p.charAt(0)=='*') return true;
        int indexS=0,indexP=0;
        int sLen=s.length(),pLen=p.length();
        while(indexS<sLen && indexP<pLen){
            
            
            //match one single character
            if(p.charAt(indexP)=='?'){
                indexP++;
                indexS++;
                
                
            //match a sequence of characters
            }else if(p.charAt(indexP)=='*'){
                
                indexP++;
                //count wildcards, this could combine  *?*??, the rules are simple
                //once a * is found any other star found in a group is irrelevant
                //the important thing is to count the number of ? signs
                while(indexP<pLen && (p.charAt(indexP)=='*' || p.charAt(indexP)=='?')){
                    if(p.charAt(indexP)=='?'){
                        indexS++;
                    }
                    indexP++;
                }
                if(indexP==pLen && indexS==sLen) return true;
                if(indexS>=sLen) return false; //s does not have enough characters to match
                if(indexP==pLen) return true; //wildcard matched
                
                char nextChar=p.charAt(indexP);
                
                while(indexS<sLen){
                    if(s.charAt(indexS)==nextChar){
                        //indexS++;
                        //indexP++;
                        //System.out.println("tsting s "+s.substring(indexS+1,sLen));
                        //System.out.println("tsting p "+p.substring(indexP+1,pLen));
                        if(isMatch(s.substring(indexS+1,sLen),p.substring(indexP+1,pLen))) return true;
                    }
                    indexS++;
                }
                
                //if I finished S and nextChar is not matched
                if(indexS==sLen) return false;
                //
                //if(index)
                
            //match characters one to one
            }else{
                if(s.charAt(indexS)!=p.charAt(indexP)){
                    return false;
                }else{
                    indexP++;
                    indexS++;
                }
            }
        }
        while(indexP<pLen && p.charAt(indexP)=='*') indexP++;
        if(indexS!=sLen || indexP!=pLen) return false;
        return true;
    }
}