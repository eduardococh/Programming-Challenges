        //Solution by leetcode's ndec09 based on zjh08177 post
        // 
class Solution {
    public String minWindow(String s, String t) {
    int [] map = new int[128];
    for (char c : t.toCharArray()) {
        map[c]++;
    }
    int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
    while (end < s.length()) {
        final char c1 = s.charAt(end);
        if (map[c1] > 0) counter--;
        map[c1]--;
        end++;
        while (counter == 0) {
            if (minLen > end - start) {
            minLen = end - start;
            minStart = start;
        }
        final char c2 = s.charAt(start);
        map[c2]++;
        if (map[c2] > 0) counter++;
        start++;
      }
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
  }
}
        
        //My solution using sliding window and character array
        //Bad runtime at 27ms better than only 13.40% O(N) (if we consider the 255 checks in every iteration constant)
        //Averabe memory better than 46.81% O(1) (if we consider the array constant)
        //Not the best, but it works
class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        int tc[]=new int[128],sc[]=new int[128];
        final int len=s.length(),len2=t.length();
        String result="."+s;
        for(int i=0;i<len2;i++){
            tc[t.charAt(i)]++;
            sc[s.charAt(i)]++;
        }
        if(check(tc,sc)) result=s.substring(0,len2);
        int start=0,end=len2;
        while(end<len){
            while(end<len && !check(tc,sc)){//While substring is not correct
                sc[s.charAt(end)]++;
                end++;
            }
            while(end<len && start<len && check(tc,sc)){//while substring is correct
                if(end-start<result.length()){
                    result=s.substring(start,end);
                }
                sc[s.charAt(start)]--;
                start++;
            }
            //substring is correct
        }
        while(start<len && check(tc,sc)){
            if(end-start<result.length()){
                result=s.substring(start,end);
            }
            sc[s.charAt(start)]--;
            start++;
        }
        if(result.charAt(0)=='.'){
            return "";    
        }else{
            return result;
        }
    }
    
    public boolean check(int[] tc,int[] sc){
        for(int i=0;i<128;i++){
            if(tc[i]>0){
                if(sc[i]<tc[i]) return false;
            }
        }
        return true;
    }
}