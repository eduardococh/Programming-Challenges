        //My solution using one pointer
        //Very simple and easy problem
        //Good runtime of 1ms better than 95.27% O(N)
        //Good memory better than 93.49% O(1)
class Solution {
    public void reverseString(char[] s) {
        final int len=s.length;
        for(int i=0;i<len/2;i++){
            char aux=s[i];
            s[i]=s[len-i-1];
            s[len-i-1]=aux;
        }
    }
}