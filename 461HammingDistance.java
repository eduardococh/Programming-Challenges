class Solution {
		//My solution, pretty obvious
		//Better runtime than 92.66% and less memory than 100%
		//Pretty good id say
		//Runtime O(n) memory ¿o(n)?
    public int hammingDistance(int x, int y) {
        String xs=Integer.toBinaryString(x);
        String ys=Integer.toBinaryString(y);
        if(xs.length()<ys.length()){
            while(xs.length()<ys.length()){
                xs='0'+xs;
            }
        }else{
            while(ys.length()<xs.length()){
                ys='0'+ys;
            }
        }
        int cont=0,length=xs.length();
        for(int i=0;i<length;i++){
            if(xs.charAt(i)!=ys.charAt(i)){
                cont++;
            }
        }
        return cont;
    }

		//Shortest solution
		//0 ms, faster than 100% and less memory than 100%, not interesting
		//by leetcode shawngao
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}

		//Solution with bit shifting, interesting
	//Faster than 100% and less memory than 100%, would recommend this one, uses .1 mb more than bitcount
		//by leetcode tankztc, is Wegner Algorithm
	//Explanation by AMoghrabi
//Using example 1111 (15) and 0000 (0):

//1111 ^ 0000 = 1111
//------------------
//1111(15) & 1110(14) = 1110 (1)
//1110(14) & 1101(13) = 1100 (2) 
//1100(12) & 1011(11) = 1000 (3)
//1000(08) & 0111(07) = 0000 (4)

//Using example 1111 (15) and 0110 (6):

//1111 ^ 0110 = 0110
//------------------
//0110(6) & 0101(5) = 0100 (1)
//0100(4) & 0011(3) = 0000 (2)

   public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        
        while (xor != 0) {
            xor &= (xor - 1);
            count++;
        }
        return count;
    }

}