        //My solution
        //All optimal solutions are similar to this one but with improvements
        //Good runtime of 5ms better than 93.48% O(N) where N is the total number
        //of characters in all words since every comparison takes constant time
        //Good memory better than 70% O(1) (goods array has constant space of 26)

class Solution {
    public int countCharacters(String[] words, String chars) {
        if(words==null || words.length==0 || chars==null || chars.length()==0) return 0;
        int[] goods=getChars(chars);
        int res=0;
        for(String word:words){
            boolean valid=true;
            int[] local=Arrays.copyOf(goods, goods.length);
            for(char car:word.toCharArray()){
                if(local[car-'a']>0){
                    local[car-'a']--;
                }else{
                    valid=false;
                    break;
                }
            }
            if(valid){
                res+=word.length();
            }
        }
        return res;
    }
    
    public int[] getChars(String chars){
        int[] res=new int[26];
        for(char car:chars.toCharArray()){
            res[car-'a']++;
        }
        return res;
    }
}