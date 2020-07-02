class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String cleaned=cleaner(paragraph);
        String words[]=cleaned.split(" ");
        HashSet<String> bannedWords=new HashSet<>();
        for(String bannedW:banned){
            bannedWords.add(bannedW);
        }
        HashMap<String,Integer> counter=new HashMap<>();
        int mostOcurrences=0;
        String res="";
        for(String word:words){
            if(!bannedWords.contains(word)){
                //I'm not banned
                if(counter.containsKey(word){
                    counter.put(word,couter.get(word)+1); 
                }
            }
        }
        return res;
    }
}