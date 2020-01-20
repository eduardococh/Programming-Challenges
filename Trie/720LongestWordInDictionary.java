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
                //System.out.println(word.substring(0,i+1));
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