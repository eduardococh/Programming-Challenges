class Solution {
		//My Solution (gauss formula apparently)
    public int missingNumber(int[] nums) {
        int sumatoria=0;
        int expected=0;
        for(int i=0;i<nums.length;i++){
            expected+=i+1;
            sumatoria+=nums[i];
        }
        return expected-sumatoria;
    }
}