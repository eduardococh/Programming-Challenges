        //My solution using hashmap and sliding window
        //Good runtime of 7ms better than 61.83% O(N)
        //Bad memory better than 6% O(N)
        //Leetcode map solution claims to have runtime of O(N K) for bad cases, looks like its different from mine
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0) return 0;
        HashMap<Character,Integer> myChars=new HashMap<Character,Integer>();
        int start=0,end=0,res=0;
        final int len=s.length();
        while(end<len){
            while(myChars.size()<=k && end<len){
                if(myChars.containsKey(s.charAt(end))){
                    myChars.put(s.charAt(end),myChars.get(s.charAt(end))+1);
                }else{
                    myChars.put(s.charAt(end),1);
                }
                if(myChars.size()<=k){
                    if(end+1-start>res) res=end+1-start;
                }
                end++;
            }
            while(myChars.size()>k && start<end){
                if(myChars.get(s.charAt(start))==1){
                    myChars.remove(s.charAt(start));
                }else{
                    myChars.put(s.charAt(start),myChars.get(s.charAt(start))-1);
                }
                start++;
            }
        }
        return res;
    }
}