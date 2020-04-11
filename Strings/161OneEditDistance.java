        //My solution
        //A little like the lazy approach
        //Amazing runtime of 0ms better than 100% O(N)
        //Good memory better than 85.29% O(1)
        //Fast and efficient, but could be more elegant
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s==null || t==null) return false;
        if(s.length()==0 && t.length()==0) return false;
        if(s.length()+1==t.length()){//insert a character in s
            final int len=s.length();
            boolean replace=false;
            for(int i=0,j=0;i<len;i++){
                if(s.charAt(i)!=t.charAt(j)){
                    if(replace) return false;
                    if(s.charAt(i)==t.charAt(j+1)){
                        replace=true;
                        j++;
                    }else{
                        return false;
                    }
                }
                j++;
            }
            return true;
        }
        if(s.length()-1==t.length()){//delete a character in s
            final int len=t.length();
            boolean replace=false;
            for(int i=0,j=0;j<len;j++){
                if(s.charAt(i)!=t.charAt(j)){
                    if(replace) return false;
                    if(s.charAt(i+1)==t.charAt(j)){
                        replace=true;
                        i++;
                    }else{
                        return false;
                    }
                }
                i++;
            }
            return true;
        }
        if(s.length()==t.length()){//replace a character in s
            final int len=s.length();
            boolean replace=false;
            for(int i=0;i<len;i++){
                if(s.charAt(i)!=t.charAt(i)){
                    if(replace) return false;
                    replace=true;
                }
            }
            return replace;
        }
        return false;
    }
}

        //Leetcode's solution
        //
class Solution {
  public boolean isOneEditDistance(String s, String t) {
    int ns = s.length();
    int nt = t.length();

    // Ensure that s is shorter than t.
    if (ns > nt)
      return isOneEditDistance(t, s);

    // The strings are NOT one edit away distance  
    // if the length diff is more than 1.
    if (nt - ns > 1)
      return false;

    for (int i = 0; i < ns; i++){
      if (s.charAt(i) != t.charAt(i)){
        // if strings have the same length
        if (ns == nt)
          return s.substring(i + 1).equals(t.substring(i + 1));
        // if strings have different lengths
        else
          return s.substring(i).equals(t.substring(i + 1));
      }
    }

    // If there is no diffs on ns distance
    // the strings are one edit away only if
    // t has one more character. 
    return (ns + 1 == nt);
  }
}