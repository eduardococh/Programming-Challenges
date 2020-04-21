        //My solution using hashmap
        //Average runtime of 7ms better than 61.75% O(N)
        //Bad memory better than only 14%
        //Could be more elegant
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0) return 0;
        HashMap<Character,Integer> myChars=new HashMap<Character,Integer>();
        int start=0,end=0;
        final int len=s.length();
        int max=0;
        while(end<len && start<len){
            if(myChars.containsKey(s.charAt(end))){//I can add without problem
                myChars.put(s.charAt(end),myChars.get(s.charAt(end))+1);
                end++;
            }else{//im a new character, check if i can add
                if(myChars.size()>=k){//i can not add myself
                    while(myChars.size()>=k && start<len){
                        if(myChars.get(s.charAt(start))>1){
                            myChars.put(s.charAt(start),myChars.get(s.charAt(start))-1);
                        }else{
                            myChars.remove(s.charAt(start));
                        }
                        start++;
                    }
                }else{//i can add
                    myChars.put(s.charAt(end),1);
                    end++;
                }
            }
            if(end-start>max){
                max=end-start;
            }
        }
        return max;
    }
}