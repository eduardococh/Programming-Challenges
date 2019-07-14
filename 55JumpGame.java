		//My solution
		//It works, but it's not the best example
		//Bad runtime of 173ms better than only 25% O(N^2)
		//Amazing memory better than 99.97%
		//An easy to come up solution, brute force approach, not dynamic programming
		//After reading leetcode's solution I found that this is actually a dp solution
		//Since we save the state in the array as a -1, avoiding duplicate work and reaching
		//a n^2 runtime
		//This leetcode article is amazing, greatly explained and even talks about interview behaviour
class Solution {
    public boolean canJump(int[] nums) {
        nums[nums.length-1]=-1;
        for(int i=nums.length-2;i>=0;i--){
            while(nums[i]>0){
                if(i+nums[i]<nums.length && nums[i+nums[i]]==-1){
                    nums[i]=-1;
                    break;
                }
                nums[i]--;
            }
        }
        if(nums[0]==-1){
            return true;
        }else{
            return false;
        }
    }
}

		//Leetcode offers a recursive backtracking approach that
		//throws a time limit excedeed, not going to cover it but it's the
		//real brute force, covering every possible path

		//Leetcode offers a dp top-down approach, whose runtime is terrible at 1392ms
		//Not going to cover it, it's like an optimized backtracking, using recursion and
		//an array to save the state of a position

		//Leetcode's dp bottom-up approach, removes recursion and archieves better runtime	
		//Important to note use of enums, which should be used to avoid "magic numbers" and
		//show's good programming practices
		//It is the same as my approach, the use of the memo array makes for the few extra miliseconds
		//compared to my approach
		//Runtime of 189ms, better than 22% O(N^2) 16ms longer than my approach (but this might
		//be preferred since it does not modify the input array as my approach does)
		//Memory of 40.9mb better than  51.1% O(N)
enum Index {
    GOOD, BAD, UNKNOWN
}

public class Solution {
    public boolean canJump(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Index.GOOD;
    }
}

		//Leetcode's greedy approach
		//Simply amazing and elegant approach, great logic
		//We use a "leftmostGoodIndex" variable that starts at arr.length-1
		//And for every position we ask if we can reach "leftmostGoodIndex"
		//if we do then we are the new "leftmostGoodIndex", we return
		//wheter or not "leftmostGoodIndex" is equal to 0 (the first position)
		//Amazing runtime of 1ms(or 0ms but couldn't get that) better than 99.51% (or 100%)
		//runtime of O(n)
		//Amazing memory of 36.5mb better than 100% o(1)
		//Really an amazing algorithm, simple and elegant, note as article says
		//that in an interview it is not so easy to come up, so start with backtracking and 
		//improve on that with dp
class Solution {
    
    public boolean canJump(int[] nums) {
        int lastPosition = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPosition) {
                lastPosition = i;
            }
        }
        
        return lastPosition == 0;
    }
}