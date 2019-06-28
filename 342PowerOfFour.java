		//My solution with loop (time limit excedeed)
		//Simple but wrong, this problem involves a lot of bit manipulation
class Solution {
    public boolean isPowerOfFour(int num) {
        int i=1;
        while(i<=num){
            if(i==num){
                return true;
            }
            i*=4;
        }
        return false;
    }
}


		//Bit manipulation solution
		//
public class Solution {
    public boolean isPowerOfFour(int num) {
        return (num&(num-1))==0 && num>0 && (num-1)%3==0;
    }
}
