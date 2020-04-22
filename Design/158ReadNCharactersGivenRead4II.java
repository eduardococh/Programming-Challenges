        //My solution
        //Brought toguether in a mock interview so quick implementation, not clearly tought
        //Amazing runtime of 0ms better than 100% O(N)
        //Bad memory better than only 6.67% O(1)
public class Solution extends Reader4 {
    
    private char char4[]=new char[4];
    private int readen=4;
    private int written=4;
    
    public int read(char[] buf, int n) {
        //System.out.println(readem+" "+written);
        if(written==readen){
            readen=read4(char4);   
            written=0;
        }
        int i=0;
        while(readen>0){
            while(written<readen){
                if(i<n){
                    if(char4[written]==0) return i;
                    buf[i++]=char4[written];    
                    written++;
                }else{
                    break;
                }
            }
            if(i==n) break;
            readen=read4(char4);
            written=0;
        }
        return i;
    }
}