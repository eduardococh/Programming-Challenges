		//In this problem my error was not understanding the concept of prime
		//divisibility good enough, so for 14 you cant get to 1 because you need 7
		//so by dividing between 2,3 and 5 you get to the result

		//solution by leetcode's young_stone
		//Great runtime 1ms faster than 98% o(n)
		//Average memory at 33.5mb less than 14% but this is not a safe measure	
public boolean isUgly(int num) {
    if (num <= 0) {return false;}
    if (num == 1) {return true;}
    if (num % 2 == 0) {
        return isUgly(num/2);
    }
    if (num % 3 == 0) {
        return isUgly(num/3);
    }
    if (num % 5 == 0) {
        return isUgly(num/5);
    }
    return false;
}

		//Iterative solution
		//Same runtime and memory as recursive
class Solution {
    public boolean isUgly(int num) {
        
        if(num==0)
            return false;
        
        if(num==1)
            return true;
        while(num%2==0)
            num=num/2;
        while(num%3==0)
            num=num/3;
        while(num%5==0)
            num=num/5;
        return num==1;   
    }
}

		//Another iterative solution
		//Divide by 2,3,4 and 5
class Solution {
    public boolean isUgly(int num) {
        if(num<=0) return false;
        if(num <= 2) return true;
        for (int i=2; i<6 && num>0; i++)
            while (num % i == 0)
                num /= i;
        return num == 1;
    }
}
