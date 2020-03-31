        //My dp solution
        //Simple problem, very similar to the famous fibonacci sequence 
        //Amazing runtime better than 100% O(N)
        //Bad memory better than only 5-6% O(N)
class Solution {
    public int climbStairs(int n) {
        int memo[]=new int[n];
        return climbStairs(n,0,memo);
    }
    
    public int climbStairs(int n,int cur,int[] memo){
        if(cur==n) return 1;
        if(cur>n) return 0;
        if(memo[cur]>0) return memo[cur];
        int total=0;
        total+=climbStairs(n,cur+1,memo);
        total+=climbStairs(n,cur+2,memo);
        memo[cur]=total;
        return total;
    }
}

        //Iterative solution by leetcode's liaison
        //Same runtime and memory as my solution
        //Big difference in memory since this is O(1)
        //But leetcode memory measurements are not always what would be expected
public int climbStairs(int n) {
    // base cases
    if(n <= 0) return 0;
    if(n == 1) return 1;
    if(n == 2) return 2;
    
    int one_step_before = 2;
    int two_steps_before = 1;
    int all_ways = 0;
    
    for(int i=2; i<n; i++){
    	all_ways = one_step_before + two_steps_before;
    	two_steps_before = one_step_before;
        one_step_before = all_ways;
    }
    return all_ways;
}

        //Time limit exceeded recursive solution
        //Brute force, calls are big  since every level duplicates
        //Time complexity O(2^N)
class Solution {
    public int climbStairs(int n) {
        return climbStairs(n,0);
    }
    
    public int climbStairs(int n,int cur){
        if(cur==n) return 1;
        if(cur>n) return 0;
        int total=0;
        total+=climbStairs(n,cur+1);
        total+=climbStairs(n,cur+2);
        return total;
    }
}