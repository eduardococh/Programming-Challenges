		//My solution using dynamic programming
		//Average runtime at 10ms better than 55.80% O(n^2) bc is around o(n*(n/2)) which is o(n^2)
		//Average memory at 36mb better than 59.80%
		//Good solution I think, but not the best or recommended
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0 || nums==null) return 0;
        
        int[] sequences=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            sequences[i]=1;
            int currentMax=0;
            int indexMax=-1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i] && sequences[j]>currentMax){
                    currentMax=sequences[j];
                    indexMax=j;
                }
            }
            if(indexMax>=0){
                sequences[i]+=sequences[indexMax];
            }
        }

        int result=0;
        for(int i=0;i<nums.length;i++){
            if(sequences[i]>result){
                result=sequences[i];
            }
        }
        return result;
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

		//Leetcode's dynamic programming with binary search
		//Great runtime at 1ms better than 90% O(N log N)
		//Average memory better than only 40% 
		//
		//Note: Arrays.binarySearch() method returns index of the search key, 
		//if it is contained in the array, else it returns (-(insertion point) - 1) that we recover with -(i + 1). 
		//The insertion point is the point at which the key would be inserted into the array:
		//the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key.
		
		//Note: dp array does not result in longest increasing subsequence, but length of dp array will give you length of LIS.

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