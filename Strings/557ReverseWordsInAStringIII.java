        //My Solution
        //Average-good runtime of 5ms better than 67.95% O(N)
        //Amazing memory better than 100% O(N)
class Solution {
    public String reverseWords(String s) {
        String words[]=s.split(" ");
        StringBuilder result=new StringBuilder("");
        for(String word:words){
            result.append(new StringBuilder(word).reverse()+" ");
        }
        return result.toString().substring(0,result.length()-1);
    }
}


        //Solution from 1ms samples
        //Amazing runtime 1ms better than 100%
        //Amazing memory better than 100% O(N)
        //Make string a char array, and then modify the char array
        //Search for the next whitespace, once found reverse the word
        //It is really fast since no string or string builder is used
        //only a simple char array that then is turned into a string
class Solution {
    public String reverseWords(String s) {
        char[] chrs = s.toCharArray();
        int i = 0;
        while(i < chrs.length){
            int spI = getNextSpaceIndex(chrs, i);
            reverse(chrs, i, spI);
            i = spI + 1;
        }
        return new String(chrs);
    }
    
    private int getNextSpaceIndex(char[] chrs, int start){
        while(start < chrs.length && chrs[start] != ' '){
            start++;
        }
        return start;
    }
    
    private char[] reverse(char[] chrs, int s, int e){
        e--;
        while(s < e){
            swapChars(chrs, s++, e--);    
        }
        
        return chrs;
    }
    
    private void swapChars(char[] chrs, int i, int j){
        char tmp = chrs[i];
        chrs[i] = chrs[j];
        chrs[j] = tmp;
    }
}