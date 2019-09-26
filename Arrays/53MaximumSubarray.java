        //MY O(N) solution
        //Bad runtime at 6ms better than only 7.22
        //Good memory better than 80.75% O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            //System.out.println("number "+nums[i]+" "+maxSum);
            if(currentSum+nums[i]<=0){
                currentSum=nums[i];
                if(currentSum>maxSum){
                    maxSum=currentSum;
                }
                currentSum=0;
            }else{
                currentSum=currentSum+nums[i];
                if(currentSum>maxSum){
                    maxSum=currentSum;
                }
            }
        }
        return maxSum;
    }
}

        //Recomended solution from leetcode's 0ms sample
        //Simple math, if a position in the array is equal or bigger than 0 extend array
        //If current array is bigger than max, max is current
        //Simple and good runtime of 0ms better than 100%
        //Bad memory thou, which makes no sense since were using constant space O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return Integer.MIN_VALUE;
        int current = nums[0];
        int max = current;
        for (int i = 1; i < n; i++) {
            if (current < 0) {
                current = nums[i];
            }
            else {
                current += nums[i];
            }
            if (current > max) max = current;
        }
        return max;
    }
}



//DP solution
//This solution runtime is the same as my first solution, no need for dp really
//can be done using O(1) space
public int maxSubArray(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
    dp[0] = nums[0];
    int max = dp[0];
    
    for(int i = 1; i < n; i++){
        dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
        max = Math.max(max, dp[i]);
    }
    
    return max;
}
