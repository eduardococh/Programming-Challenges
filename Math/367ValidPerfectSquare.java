		//from leetcode's fhqplzj
		//Very clever approach using the pattern
		//1,3,5,7,9 ... and if the result is one of this sequence then it is a perfect square
		//Average runtime of 1ms better than 29.38%
		//Bad memory
class Solution {
    public boolean isPerfectSquare(int num) {
     int i = 1;
     while (num > 0) {
         num -= i;
         i += 2;
     }
     return num == 0;
 }
}

		
		//Newton's method approach, use of long so 
		//int does not overflow, fast
		//at 0ms
    class Solution {
       public boolean isPerfectSquare(int num) {
            long x = num;
            while (x * x > num) {
                x = (x + num / x) >> 1;
            }
            return x * x == num;
        }
    }