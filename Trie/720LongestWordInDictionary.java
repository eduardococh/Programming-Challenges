class Solution {
    public String longestWord(String[] words) {
        ArrayList<String> candidates=new ArrayList<String>();
        HashMap<String,Boolean> dp=new HashMap<String,Boolean>();
        for(String word:words){
            if(word.length==1){
                dp.put(word,true);
            }else{
                
            }
        }
        return "";
    }
}