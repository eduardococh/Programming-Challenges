public class Solution {
		//My solution bad runtime beating 5.36% and memory usage better than 42.81%
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        StringBuilder sb=new StringBuilder("");
        while(n!=0){
            sb.append(n&1);
            n=n>>>1;
        }
        while(sb.length()<32){
            sb.append('0');
        }
        int res=0,magnitude=1;
        for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i)=='1'){
                res=res+magnitude;
            }
            magnitude=magnitude*2;
        }
        return res;
    }
}