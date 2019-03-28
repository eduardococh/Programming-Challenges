//My solution, time limit exceded
public boolean isPowerOfThree(int n) {
        if(n==0) return false;
        if(n==1) return true;
        int power=1;
        while(power<n){
            power=power*3;
        }
        return (power==n);
    }

//Simple leetcode solution
public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }