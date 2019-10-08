class Solution {
		//My solution, 0ms (all solutions are 0ms)
		//Memory beats 38.19%, took me 8min
		//o(n) memory, o(n) memory (one extra array)
    public int[] plusOne(int[] digits) {
        int num=0,newArr[]=new int[digits.length+1];
        boolean is9=true;
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]!=9){
                digits[i]++;
                newArr[i+1]=digits[i];
                return digits;
            }else{
                digits[i]=0;
                newArr[i+1]=0;
            }
        }
        newArr[0]=1;
        return newArr;
    }
}

class Solution {
		//Genius solution, sample from leetcode
		//like my code, one less array and great second array set
		//o(n) runtime, o(1) memory
		//when i runned it it took more memory than it appeared as sample
		//dont know why, but it obviously takes less memory
    public int[] plusOne(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }
}