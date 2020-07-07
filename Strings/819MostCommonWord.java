        //My solution
        //Good runtime better than 79.6% O(N+B) where N is paragraph lenght and B banned lenght
        //Bad memory better than only 17.15% O(N+B)
        //Simple and clear enough
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
                if(counter.containsKey(word)){
                    counter.put(word,counter.get(word)+1); 
                }else{
                    counter.put(word,1);
                }
                if(counter.get(word)>mostOcurrences){
                    mostOcurrences=counter.get(word);
                    res=word;
                }
            }
        }
        return res;
    }
    
    private String cleaner(String paragraph){
        boolean space=true;
        paragraph=paragraph.toLowerCase();
        char[] charArr=paragraph.toCharArray();
        StringBuilder result=new StringBuilder("");
        for(char character:charArr){
            if(character>='a' && character<='z'){
                result.append(character);
                space=true;
            }else if(space){
                result.append(' ');
                space=false;
            }
        }
        return result.toString();
    }
}

    
    //Solution from leetcode 4ms samples
    //Create words as you go, clever approach and avoids creation of cleaner method like me
    //Runtime of 4ms
    //NOTE initial point added to paragraph to make it work
    //When I ran this solution it achieved a worse runtime of 13ms and 16 better than 49% and similar memory
    //to my solution, probably that my method is probably faster in runtime
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }
}