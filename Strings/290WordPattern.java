		//My solution
		//Great runtime better than 99.17% O(N) where n is pattern length
		//Good memory better than 84.57% O(N)
		//Simple and clear

class Solution {
    public boolean wordPattern(String pattern, String str) {

        String[] words=str.split(" ");
        if(pattern.length()!=words.length) return false;
        final int length=pattern.length();
        Map<Character,String> map=new HashMap<>();
        Map<String,Character> mapI=new HashMap<>();

        for(int i=0;i<length;i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(words[i])){
                    return false;
                }
                
            }else{
                map.put(pattern.charAt(i),words[i]);
            }
            if(mapI.containsKey(words[i])){
                if(mapI.get(words[i])!=pattern.charAt(i)){
                    return false;
                }
            }else{
                mapI.put(words[i],pattern.charAt(i));
            }
            
        }
        return true;
    }
}


		//From leetcode's sample 1ms
		//Solution using only 1 map, instead of the two i used
		//map used is char,string
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(pattern.length() != words.length) return false;
        Map<Character, String> map = new HashMap();

        for(int i =0; i< words.length; i++ ) {
            if(map.containsKey(pattern.charAt(i)))   {
                if (!map.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                  }                      
                
            }else if(map.containsValue(words[i])) {
                return false;
            } else{
               map.put(pattern.charAt(i), words[i]) ;
            }
        }
        return true;
        
    }
}


		//0ms solutions do exist but are not trivial 
		//like for a 45 minutes interview so ill skip them