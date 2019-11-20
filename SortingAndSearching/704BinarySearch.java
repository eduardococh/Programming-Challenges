        //My binary search approach
        //Maybe a typical textbook implementation
        //Not a lot to comment
        //PERSONAL ERRORS
        //LOW<=HIGH since mid could fall in the middle
        //HIGH = LENGTH-1 avoid overflow
        //If it is not found in the loop return -1
class Solution {
    public int search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}