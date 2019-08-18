class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int currentLargest=nums[0],currentLargestNeg=nums[0],currentMul=nums[0];
        for(int i=1;i<nums.length;i++){
            //System.out.println(currentMul);
            //System.out.println(currentLargestNeg);
            
                //0 breaks sequence positive and negative
            if(nums[i]==0){
                if(currentMul>currentLargest){
                    currentLargest=currentMul;
                }
                currentMul=0;
                currentLargestNeg=0;
                
                //Negative number can be added only on pairs
            }else if(nums[i]<0){
                currentLargestNeg*=nums[i];
                currentMul=1;
                
                //Number is positive, we can extend currentMul
            }else{
                currentMul*=nums[i];
                currentLargestNeg*=nums[i];
            }
            
            if(currentMul>currentLargest){
                currentLargest=currentMul;
            }
            if(currentLargestNeg>currentLargest){
                currentLargest=currentLargestNeg;
            }
            
        }
        return currentLargest;
    }
}