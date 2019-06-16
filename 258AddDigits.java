		/My solution
		//Simple and straighforward
		//Good runtime at 1ms better than 97%
		//Leetcode's sample 0ms run in 1ms for me so don't trust this measure
		//Runtime of O(N) where n is digits on number
		//Bad memory only better than 12%, buuut I ran the best memory from sample and was like
		//my problem so dont trust this measure
class Solution {
    public int addDigits(int num) {
        int aux=0;
        while(num>9){
            while(num>0){
                aux+=num%10;
                num=num/10;
            }
            num=aux;
            aux=0;
        }
        return num;
    }
}

		//Simple solution from leetcode's 0ms, but when I ran it took 1ms
class Solution {
    public int addDigits(int num) {
        while(num>=10){
             num=(num-1)%9+1;
        }
        return num;
    }
}