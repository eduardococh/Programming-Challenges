class Solution {
		//MY O(N) solution
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

	//Commented DP solution
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
}
