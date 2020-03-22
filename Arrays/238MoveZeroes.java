class Solution {
		//My solution, pretty good beating 100% in runtime and 73.93 in memory
		//Pretty clear, could be better memory avoiding aux;
		//O(n) runtime, o(1) memory
    public void moveZeroes(int[] nums) {
        int zeroes=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroes++;
            }else{
                int aux;
                aux=nums[i-zeroes];
                nums[i-zeroes]=nums[i];
                nums[i]=aux;
            }
        }
    }
}

class Solution {
		//Best memory from leetcode sample, 100% runtime and  94% memory
		//This was best memory in leetcode samples but it was not that good in my run
		//Get all numbers different than 0 to first places and then fill rest with zeroes
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int n: nums){
            if(n != 0) nums[index++] = n;
        }
        
        for(int i = index; i < nums.length; i++) nums[i] = 0;
    }
}