        //My solution
        //Two pointer, read and write
        //Amazing runtime better than 97.05% O(N)
        //Amazing memory better than 100% O(1)
        //A good approach, maybe complex but well
class Solution {
    public int compress(char[] chars) {
        if(chars==null || chars.length==0) return 0;
        if(chars.length==1) return 1;
        char current=chars[0]; 
        int cont=1,writePos=0;
        for(int i=1;i<chars.length;i++){
            //System.out.println(chars[i]);
            if(chars[i]==current){
                cont++;
            }else{
                if(cont>1){
                    chars[writePos++]=current;
                    writePos=fillArray(writePos,chars,cont);
                }else{
                    chars[writePos++]=current;
                }
                current=chars[i];
                cont=1;
            }
        }
        if(cont>1){
            chars[writePos++]=current;
            writePos=fillArray(writePos,chars,cont);
        }else{
            chars[writePos++]=current;
        }
        return writePos;
    }
    
    private int fillArray(int writePos,char[] chars,int cont){
        //System.out.println("in method "+cont);
        //System.out.println(Math.log10(cont));
        int length=(int)Math.floor(Math.log10(cont))+1;
        int power=(int)Math.pow(10,length-1);
        //System.out.println("len "+length);
        for(int i=0;i<length;i++){
            //System.out.println("cont "+cont);
            //System.out.println("power "+power);
            //System.out.println("rse "+cont/power);
            chars[writePos++]=(char)((cont/power)+'0');
            cont%=power;
            power/=10;
        }
        return writePos;
    }
}


        //Leetcode's article solution
        //Iterate array with read variable, write variable self explains
        //currentChar saves the character currently being processed
        //Same runtime as my solution and memory little better
        //Amazing runtime better than 96.95%
        //Clever handling of the integer 1 digit problem, by converting integer
        //to string, and then to char array
class Solution {
    public int compress(char[] chars) {
        int currentChar = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[currentChar];
                if (read >  currentChar) {
                    for (char c: ("" + (read - currentChar + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                currentChar = read + 1;
            }
        }
        return write;
    }
}