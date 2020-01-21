        //Leetcode's brute force
        //Good runtime of 6ms better than 94.37% (complex bigO)
        //Bad memory better than only 6.25% (complex bigO)
        //Simple and genius approach, put them all in a set and then compare only 
        //words which are larger and candidates to be new result, that way you avoid a lot of processing
        //
class Solution {
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> wordset = new HashSet();
        for (String word: words) wordset.add(word);
        for (String word: words) {
            if (word.length() > ans.length() ||
                    word.length() == ans.length() && word.compareTo(ans) < 0) {
                boolean good = true;
                for (int k = 1; k < word.length(); ++k) {
                    if (!wordset.contains(word.substring(0, k))) {
                        good = false;
                        break;
                    }
                }
                if (good) ans = word;
            }    
        }
        return ans;
    }
}

        //My initial brute force solution
        //Terrible runtime of 37ms better than only 7% O(MN)??
        //Terrible memory of 47.8mb better than only 6.25%  O(MN)??
        //Not very useful,
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        HashSet<String> prefixes=new HashSet<String>();
        String result="";
        for(String word:words){
            if(word.length()==1){
                prefixes.add(word);
                if(word.length()>result.length()){
                    result=word;    
                }
                continue;
            }
            int i;
            for(i=0;i<word.length()-1;i++){
                String prefix=word.substring(0,i+1);
                if(!prefixes.contains(prefix)){
                    break;
                }
            }
            prefixes.add(word);
            if(i==word.length()-1){
                if(word.length()>result.length()){
                    result=word;
                }
            }
        }
        return result;
    }
}