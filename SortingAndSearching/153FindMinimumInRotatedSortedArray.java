        //My solution (based on EPI)
        //Amazing runtime better than 100% O(Log N)
        //Amazing memory O(1)
        //Here we are looking for the smaller number, so that's a small modification
        //from the original binary search where we look for a target
        //Here we compare nums[middle] to nums[right], if we are bigger than means that the smaller
        //is to our right, if we are smaller than nums[right] that means the smaller number could
        //the to our left or could be middle 
        //
class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0) return 0;
        int low=0,high=nums.length-1;
        //loop ends when low==high
        while(low<high){
            int med=low+(high-low)/2;
            if(nums[med]>nums[high]){
                low=med+1;
            }else{
                high=med;
            }
        }
        return nums[low];
    }
}


class Solution {
  public int findMin(int[] nums) { 
    if (nums.length == 1) {
      return nums[0];
    }
    int left = 0, right = nums.length - 1;
    if (nums[right] > nums[0]) {
      return nums[0];
    }
    
    // Binary search way
    while (right >= left) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[mid + 1]) {
        return nums[mid + 1];
      }
      if (nums[mid - 1] > nums[mid]) {
        return nums[mid];
      }
      if (nums[mid] > nums[0]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}