        //My solution
        //Works but for a reason adds /n0000 character to array

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char buf4[]=new char[4];
        int current=read4(buf4);
        int total=0,pointer=0;
        while(current>0){
            total+=current;
            for(int i=0;i<current;i++){
                if(pointer==n) return total;
                buf[pointer++]=buf4[i];
            }
            current=read4(buf4);
            
        }
        return total;
    }
}

    //Solution from leetcode's richilee
    //Amazing runtime better than 100% O(N)
    //Amazing memory better than 100 O(1)
    //
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        
        char[] buffer = new char[4];
        boolean endOfFile = false;
        int readBytes = 0;
        
        while (readBytes < n && !endOfFile) {
            int currReadBytes = read4(buffer);
            if (currReadBytes !=4) {
                endOfFile = true;
            }
            int length = Math.min(n - readBytes, currReadBytes);
            for (int i=0; i<length; i++) {
                buf[readBytes + i] = buffer[i];
            }
            readBytes += length;
        }
        return readBytes;
    }
}


public Class readN{
	
	int genIndex=0;
	char r4[];
	char remaining[];
           int cC = 0;
	readN(){
		r4 = new char[];
}

int readN(char buf [ ], int n){

	int thisRun=0;
                                                               
	while(c>0){
		int index4=0;
		if(cC == 0)
			read4(r4);

		while(cC > 0 && thisRun<n){
buf[genIndex++]=r4[4-Cc];
thisRun++;
cC--;
}


if(thisRun>=n) {
	break;
}
if(readen!=4){ 
saveRemaining(index4,r4);
	break;
}
readen=read4(r4);
}
return thisRun;
}

}

saveRemaining(int index4,char[] r4){
	remaining=new char[3];
	int remainIndex=0;
	while(index4<4){
		remaining[remainIndex++]=r4[index4++];
}
return;
}
