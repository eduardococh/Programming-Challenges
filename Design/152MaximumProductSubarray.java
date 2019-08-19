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


int maxProduct(int A[], int n) {
    // store the result that is the max we have found so far
    int r = A[0];

    // imax/imin stores the max/min product of
    // subarray that ends with the current number A[i]
    for (int i = 1, imax = r, imin = r; i < n; i++) {
        // multiplied by a negative makes big number smaller, small number bigger
        // so we redefine the extremums by swapping them
        if (A[i] < 0)
            swap(imax, imin);

        // max/min product for the current number is either the current number itself
        // or the max/min by the previous number times the current one
        imax = max(A[i], imax * A[i]);
        imin = min(A[i], imin * A[i]);

        // the newly computed max value is a candidate for our global result
        r = max(r, imax);
    }
    return r;
}