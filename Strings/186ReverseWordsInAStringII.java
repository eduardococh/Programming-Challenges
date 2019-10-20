        //AMAZING SOLUTION
        //From leetcode's 1ms samples
        //Amazing runtime of 1ms faster than 100% O(N)
        //Amazing memory better than 92.31% O(1)
        //Usage of reverse method for reversing string
        //IMPORTANT
        //first we reverse the whole string, then we reverse word by word
        //this way we don't need extra space
class Solution {
    public void reverseWords(char[] s) {
        // reverse whole string
        reverse(s,0,s.length-1);
        // reverse each word
        int start = 0;
        for(int i=0;i<s.length;++i){
            if(s[i]==' '){
                reverse(s,start,i-1);
                start = i+1;
            }
        }
        // reverse last word ( no space at the end )
        reverse(s,start,s.length-1);
    }
    private void reverse(char[] s, int start, int end){
        while(end>start){
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}
 
        //My StringBuilder approach
        //Bad runtime of 5ms better than 5.99% O(N)
        //Amazing memory better than 100% O(N)
        //Simple approach, simpler than the character by character approach but
        //way slower, double the time of 2ms than the char approach
        //Use of extra memory so not good
class Solution {
    public void reverseWords(char[] s) {
        StringBuilder result=new StringBuilder();
        StringBuilder sb=new StringBuilder();
        for(char ch:s){
            if(ch==' '){
                sb.insert(0,' ');
                result.insert(0,sb);
                sb=new StringBuilder();
            }else{
                sb.append(ch);
            }
        }
        result.insert(0,sb);
        int cont=0;
        for(char c:result.toString().toCharArray()){
            s[cont++]=c;
        }
    }
}


        //My char by char solution
        //Average-bad runtime at 2ms better than 30.07% O(N)
        //Amazing memory better than 100% O(N) (we use aux)
        //We search string, until we find a space, when we find a space 
        //we write the word to the new string
        //IMPORTANT check the starting and ending indexes, before going to code use a
        //small to medium example and create a basic algorithm, these one that needs a
        //lot of variables are specially tricky
        //Works but used additional N space, the problem asks if you're able to do it 
        //with constant space, approach below works for that
class Solution {
    public void reverseWords(char[] s) {
        final int len=s.length;
        int wordLen=0;
        int writeI=len;
        char aux[]=new char[s.length];
        
        for(int i=0;i<len;i++){
            while(i<len && s[i]!=' '){
                i++;
                wordLen++;
            }
            if(i<len){
                aux[writeI-wordLen-1]=' ';
            }
            int auxWL=wordLen;
            
            while(wordLen>0){
                aux[writeI-wordLen]=s[i-wordLen];
                wordLen--;
            }
            
            writeI=writeI-auxWL-1;
        }
        
        for(int i=0;i<len;i++){
            s[i]=aux[i];
        }
    }
}

