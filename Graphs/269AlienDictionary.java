        //Leetcode's solution
        //Amazingly simple compared to what I thought
        //Amazing runtime of 0ms better than 100% O(M*N) where M is lenght of list and N lenght of words
        //Bad memory better than only 15% O(1), I believe it might be ¿O(N)?
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i)
            index[order.charAt(i) - 'a'] = i;

        search: for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i+1];

            // Find the first difference word1[k] != word2[k].
            // this is the only one we check
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    // If the index of the letter at word1 is bigger than the index of theletter at word two,
                    // then it is not sorted like bed coming before bad
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
                        return false;
                    continue search;
                }
            }

            // If we didn't find a first difference, the
            // words are like ("app", "apple").
            //
            if (word1.length() > word2.length())
                return false;
        }

        return true;
    }
}



class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderIndex = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderIndex[order.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i], word2 = words[i + 1];
            if (!isSorted(word1, word2, orderIndex)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isSorted(String word1, String word2, int[] orderIndex) {
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                return orderIndex[word1.charAt(i) - 'a'] < orderIndex[word2.charAt(i) - 'a'];
            }
        }
        
        return word1.length() <= word2.length();
    }
}