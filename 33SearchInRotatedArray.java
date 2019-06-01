		//My solution, took me a while
		//Tree binary searches, one altered to find the biggest number
		//Two normal to find the target
		//Great runtime at 0ms better than 100%
		//Great memory at 36.5mb, better than 99.94%
		//Overal a good solution i think, not the most elegant
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int major=binarySearchMajor(nums);
        if(target==nums[major]){
            return major;
        }else{
            int res=binarySearch(0,major-1,nums,target);
            if(res!=-1){
                return res;
            }
            res=binarySearch(major+1,nums.length,nums,target);
            if(res!=-1){
                return res;
            }else{
                return -1;
            }
        }
    }
    
    public int binarySearchMajor(int[] nums){
        int left=0,right=nums.length-1;
        while(left<right-1){
            int middle=left+(right-left)/2;
            if(nums[middle]>nums[left]){
                left=middle;
            }else{
                right=middle-1;
            }
        }
        if(nums[left]>nums[right]){
            return left;    
        }else{
            return right;
        }
        
    }
    
    public int binarySearch(int left, int right, int[] nums,int target){
        while(left<right){
            int middle=left+(right-left)/2;
            if(nums[middle]==target){
                return middle;
            }
            if(nums[middle]>target){
                right=middle;
            }else{
                left=middle+1;
            }
        }
        if(left>=0 && left<nums.length && nums[left]==target){
            return left;
        }else{
            return -1;
        }
    }
}

		//Solution based on leetcode's renegade with minor tweaks
		//Only one altered binary search with the question
		//if (nums[mid] > nums[end]) 
		//which means a 
		//Same runtime and memory as my solution, but more elegant
		//
public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {  // eg. 3,4,5,6,1,2

                if (target > nums[mid] || target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }

            } else {  // eg. 5,6,1,2,3,4

                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }

            }
        }

        if (start == end && target != nums[start]) return -1;
        return start;
    }
}