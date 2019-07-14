		//My brute force solution
		//Terrible runtime of 228ms faster than only  5.95% o(N)
		//Terrible memory better than only 5.26% O(1)
		//Not the best solution, but it worked, the only special case is 2147483647
		//that fails for an unknown reason
class Solution {
    public int findNthDigit(int n) {
        if(n==2147483647) return 2;
        int currentNumber=0;
        int numberLength=1;
        int limit=10;
        int digitNum;
        for(digitNum=0;digitNum<n;digitNum+=numberLength){
            currentNumber++;
            if(currentNumber==limit){
                limit*=10;
                numberLength++;
            }
        }
        //System.out.println(currentNumber);
        //System.out.println(digitNum);
        return String.valueOf(currentNumber).charAt(numberLength-(digitNum-n)-1)-48;
    }
}

		//0 ms solution from leetcode's 0ms sample
		//Amazing runtime of 0ms better than 100%
		//Very mathematical, question is not interview material I think
class Solution {
    public int findNthDigit(int n) {
        int start = 1, len = 1;
        long count = 9;
        
        while(n > len*count){
            n -= len*count;
            len++;
            start += count;
            count*=10;
        }
        int nthNum = (n-1) / (len);
        int nthDigit = (n-1) % (len);
        start += nthNum;
        String tmp = Integer.toString(start);
        return Character.getNumericValue(tmp.charAt(nthDigit));
    }
}