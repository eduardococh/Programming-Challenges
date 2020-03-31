        //Recursive solution
        //Bad runtime better than only 15% O(2^N) since every number duplicates calls
        //Terrible memory better than only 5.51% O(N) since the stack goes N levels deep
        //Simple but bad (memo array is used)
class Solution {
    public int fib(int N) {
        return fib(N);
    }
    
    public int fib(int cur){
        if(cur==1) return 1;
        if(cur==0) return 0;
        return fib(cur-1,memo)+fib(cur-2,memo);
    }
}

        //DP recursive solution
        //Amazing runtime better than 100% O(N)
        //Terrible memory better than only 5.51% o(N) because of array
        //Good optimized solution
class Solution {
    public int fib(int N) {
        int memo[]=new int[N+1];
        memo[0]=0;
        return fib(N,memo);
    }
    
    public int fib(int cur,int[] memo){
        if(cur==1) return 1;
        if(cur==0) return 0;
        if(memo[cur]>0) return memo[cur];
        memo[cur]=fib(cur-1,memo)+fib(cur-2,memo);
        return memo[cur];
    }
}

        //Iterative solution from leetcode's 0ms samples
        //Much better to use iterative solutions than recursive solutions because of memory
        //Amazing runtime 0ms better than 100% O(N)
        //Bad memory better than only 5.51% O(1)
class Solution {
    public int fib(int N) {
        if (N < 2) {
            return N;
        }
        
        int tmp, minus1 = 1, minus2 = 0;
        for (int i = 2; i < N; i ++) {
            tmp = minus2;
            minus2 = minus1;
            minus1 = minus2 + tmp;
        }
        
        return minus1 + minus2;
    }
}