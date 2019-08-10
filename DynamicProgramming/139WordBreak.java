        //The unbelievable simple solution from leetcode's segfault
        //Dynamic programming
        //It is really simple, but an even better implementation is available
        //It moves an I from 1 to s.length and then generates all substring from 0 to i-1, if a position in
        //f array is true (which means continuity for the string)
        //where n is dict length
        //this is not so logic as the second one i think, so i prefer next approach
        //Good runtime better than 77.59% O(N^2)
        //Good memory better than 93.48% O(N) 
public class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;

        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}

        //Optimized DP solution from leetcode's segfault
        //It goes through every position of the string and tries every string from dict, it then asks if
        //current str is smaller or equal than i and if that's true then asks for the array f in position
        //i-str.length, is this is true then is checks if this substring is equal to our str
        //Good runtime of  2ms faster than 94.43%  O(M+N)
        //Good memory of 35.9mb better than 94.48% O(N)
public class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        return f[s.length()];
    }
}

        //My long bad solution, worth keeping because of comparators and general implementation
        //but not really good
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Comparator c = new Comparator<String>()
        {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };
        Collections.sort(wordDict, c);
        Collections.sort(wordDict, Collections.reverseOrder());
        int[] sLetters=new int[26];
        for(char letter:s.toCharArray()){
            sLetters[letter-'a']=1;
        }
        ArrayList<String> wordsToBeRemoved=new ArrayList<>();
        for(String word:wordDict){
            //System.out.println(word);
            for(char letter:word.toCharArray()){
                if(sLetters[letter-'a']==0){
                    wordsToBeRemoved.add(word);
                }else{
                    sLetters[letter-'a']=2;
                }
            }
        }
        for(String word:wordsToBeRemoved){
            wordDict.remove(word);
        }
        for(int num:sLetters){
            if(num==1) return false;
        }
        return calcWord(s,wordDict,new StringBuilder(""));
    }
    
    public boolean calcWord(String s,List<String> wordDict,StringBuilder stringSoFar){
        if(stringSoFar.toString().equals(s)){
            return true;
        }
        if(stringSoFar.length()>s.length()){
            return false;
        }
        //System.out.println("we get "+stringSoFar.toString());
        for(String word:wordDict){
            //System.out.println("word "+word+" ssf "+stringSoFar.length());
            if(stringSoFar.length()+word.length()>s.length()) continue;
            //System.out.println("memem "+s.substring(stringSoFar.length(),stringSoFar.length()+word.length()));
            if(s.substring(stringSoFar.length(),stringSoFar.length()+word.length()).equals(word)){
                if(calcWord(s,wordDict,new StringBuilder(stringSoFar.toString()+word))){
                    return true;
                }
            }
        }
        return false;
    }
}