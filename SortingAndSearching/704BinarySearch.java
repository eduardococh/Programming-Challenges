        //My binary search approach
        //It is the same implementation as leetcode
        //Not a lot to comment
        //PERSONAL ERRORS
        //LOW<=HIGH since mid could fall in the middle
        //HIGH = LENGTH-1 avoid overflow
        //If it is not found in the loop return -1
        //Runtime of 0ms better than 100% O(Log(N))
        //Average memory better than 60%
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