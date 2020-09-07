//My solution using backtracking
//Amazing runtime of 2ms better than 92.74% O(A^N) ¿sure? 
//Amazing memory better than 97% O(N)
//
class Solution {
    public int numTilePossibilities(String tiles) {
        int[] letters=getLetters(tiles);
        return generatePossibilities(letters);
    }
    
    public int generatePossibilities(int[] letters){
        int res=0;
        for(int i=0;i<26;i++){
            if(letters[i]>0){
                letters[i]--;
                res++;
                res+=generatePossibilities(letters);
                letters[i]++;
            }
        }
        return res;
    }
    
    public int[] getLetters(String tiles){
        int res[]=new int[26];
        for(char letter:tiles.toCharArray()){
            res[letter-'A']++;
        }
        return res;
    }
}