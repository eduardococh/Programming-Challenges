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

        //Amazing solution from leetcode's 0ms samples
        //Amazing runtime of 0ms better than 100% O(N)
        //Simple, for every non zero you find move it to the front
        //At the end fill with zeroes
class Solution {
    public void moveZeroes(int[] nums) {
        int nonzeroNumIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[nonzeroNumIndex] = nums[i];
                nonzeroNumIndex++;
            }
        }
        
        for(int i = nonzeroNumIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}