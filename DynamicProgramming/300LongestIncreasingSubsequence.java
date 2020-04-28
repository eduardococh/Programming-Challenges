        //My solution after 3rd attempt
        //Despite solving this problem before, still struggle with it
        //But this solution is simple and logic enough to me, compared to what I got before
        //Fill from back to front, solving the problem for smaller lenghts and going to bigger lenghts
        //build solution based on previous solutions
        //Good runtime 9ms better than 71.8% O(N^2)
        //Average memory better than 57%
class Solution {
    public int lengthOfLIS(int[] nums) {
        final int len=nums.length;
        int res=0,dp[]=new int[len];
        for(int i=nums.length-1;i>=0;i--){
            int biggerSoFar=0;
            for(int j=i+1;j<len;j++){
                if(nums[j]>nums[i] && dp[j]>biggerSoFar){
                    biggerSoFar=dp[j];
                }
            }
            dp[i]=++biggerSoFar;
            if(dp[i]>res) res=dp[i];
        }
        return res;
    }
}
        
        //My solution using dynamic programming at second try
        //Similar to the one suggested by leetcode, but for me building back to front is more logic
		//Average runtime at 10ms better than 55.80% O(n^2) bc is around o(n*(n/2)) which is o(n^2)
		//Good memory at 36mb better than 93.0%
		//Good solution I think, simpler than my first try
        //Save the longest possible for every number, for every new number search the whole
        //Array behind it, looking for smaller numbers, get the bigger one and add upon it
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int[] dp=new int[nums.length+1];
        dp[0]=1;

        for(int i=1;i<nums.length;i++){
            int longestSeq=0;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    if(dp[j]>longestSeq){
                        longestSeq=dp[j];
                    }
                }
            }
            dp[i]=longestSeq+1;
        }
        int max=0;
        for(int num:dp){
            if(num>max) max=num;
        }
        return max;
    }
}

        //BEST APPROACH
		//Leetcode's dynamic programming with binary search
		//Great runtime at 1ms better than 90% O(N log N)
		//Average memory better than only 40% 
		//
		//Note: Arrays.binarySearch() method returns index of the search key, 
		//if it is contained in the array, else it returns (-(insertion point) - 1) that we recover with -(i + 1). 
		//The insertion point is the point at which the key would be inserted into the array:
		//the index of the first element greater than the key, or a.length if all elements in
        // the array are less than the specified key.
		
		//Note: dp array does not result in longest increasing subsequence, but length of dp array will
        //give you length of LIS.

public class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        int len = 0;

        for (int num : nums) {
	    //Where should my number be?
            int i = Arrays.binarySearch(dp, 0, len, num);
	    //if i is smaller than 0 it means the number is not in the array and the negative insertion point -1 is returned
            if (i < 0) {
		//recover the insertion point
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}


		//Brute force by leetcode
		//Time limit excedeed, O(2^N), because for every number bigger than prev we calculate both 
		//result if we take this and if we dont take it, which creates every solution and takes a lot 
		//Memory of O(N^2)
public class Solution {

    public int lengthOfLIS(int[] nums) {
        return lengthofLIS(nums, Integer.MIN_VALUE, 0);
    }

    public int lengthofLIS(int[] nums, int prev, int curpos) {
        if (curpos == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[curpos] > prev) {
            taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1);
        }
        int nottaken = lengthofLIS(nums, prev, curpos + 1);
        return Math.max(taken, nottaken);
    }
}