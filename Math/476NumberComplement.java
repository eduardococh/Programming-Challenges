        //Genius bit operation by leetcode's hilloni
        //Use an XOR with 1, any number XOR 1 gives the opposite number
        //Any number XOR 0 gives the same number, so here we do an XOR
        //bit by bit, we use x as our mask and shift to the right 1 by 1
        //until we do this 32 times
        //Runtime of 1ms better than 34%? O(N)
        //Memory better than 100% O(1)
        //we start with one and do it 31 times max since it is a signed integer
class Solution {
    public int findComplement(int num) {
        int x=1,i=1;
        while(x<=num && i<32){
            num=num^x;
            x=x<<1;
            i++;
        }
        return num;
    }
}