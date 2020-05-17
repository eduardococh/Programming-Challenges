        //My solution using a hashmap of mappings
        //Almost all solutions I saw use this two passes and map approach
        //Map each starting word and their phrases, then loop ending words and
        //search for matches, avoid same indexes and repeated mergings
        //Runtime of 6ms better than 77.36% O(N)
        //Amazing memory better than 100% O(N)
class Solution {
    
    class Mapping{
        int index;
        String phrase;
    }
    
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        List<String> result=new ArrayList<String>();
        HashSet<String> set=new HashSet<String>();
        HashMap<String,List<Mapping>> mapping=new HashMap<String,List<Mapping>>();
        //add the start of every phrase
        int phraseI=0;
        for(String phrase:phrases){
            String[] words=phrase.split(" ");
            /*for(String word:words){
                System.out.println(word);    
            }*/
            Mapping current=new Mapping();
            current.index=phraseI;
            current.phrase=phrase;
            if(!mapping.containsKey(words[0])){
                mapping.put(words[0],new ArrayList<Mapping>(Arrays.asList(current)));
            }else{
                List<Mapping> soFar=mapping.get(words[0]);
                soFar.add(current);
                mapping.put(words[0],soFar);
            }
            phraseI++;
        }
        //search for the end of every phrase in hash map
        phraseI=0;
        for(String phrase:phrases){
            String[] words=phrase.split(" ");
            String lastWord=words[words.length-1];
            //if there's a phrase that starts with my ending word
            if(mapping.containsKey(lastWord)){
                List<Mapping> candidates=mapping.get(lastWord);
                for(Mapping candidate:candidates){
                    if(candidate.index!=phraseI){
                        if(phrase.length()==1){
                            if(!set.contains(candidate.phrase)){
                                set.add(candidate.phrase);   
                                result.add(candidate.phrase);    
                            }
                        }else{
                            if(!set.contains((phrase.substring(0,phrase.length()-lastWord.length()))+candidate.phrase)){
                                set.add((phrase.substring(0,phrase.length()-lastWord.length()))+candidate.phrase);
                                result.add((phrase.substring(0,phrase.length()-lastWord.length()))+candidate.phrase);
                            }
                        }
                    }
                }
            }
            phraseI++;
        }
        Collections.sort(result);
        return result;
    }
}

        //Sample from leetcode's 3ms
        //My same approach but optimized
        //Put words into a map and then iterate
        //When I ran it I got the same runtime and memory as my solution
class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        String[] newPhrases = new String[phrases.length];
        Map<String, Set<Integer>> map = new HashMap<>();
        for(int j = 0; j < phrases.length; j++) {
            int i = phrases[j].indexOf(' ');
            String word = "";
            if(i == -1) word = phrases[j];
            else word = phrases[j].substring(0, i);
            newPhrases[j] = i == -1 ? "" : phrases[j].substring(i);
            
            map.putIfAbsent(word, new HashSet<>());
            map.get(word).add(j);
        }
        Set<String> resSet = new HashSet<>();
        for(int k = 0; k < phrases.length; k++) {
            int i = phrases[k].lastIndexOf(' ');
            String word = phrases[k].substring(i+1);
            if(map.containsKey(word)) {
                for(Integer j : map.get(word)) {
                    if(k == j) continue;
                    resSet.add(phrases[k] + newPhrases[j]);
                }
            }
        }
        
        List<String> res = new ArrayList<>(resSet);
        Collections.sort(res);
        
        return res;
        
    }
}