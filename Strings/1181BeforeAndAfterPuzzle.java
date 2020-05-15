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