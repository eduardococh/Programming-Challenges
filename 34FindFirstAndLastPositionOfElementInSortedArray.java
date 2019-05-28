		//My solution
		//Basically do a binary search and when found go 1 by 1 to the lower and upper
		//Suprisingly good at 0ms, better than 100%
		//Very surprising memory at 39.2mb better than 99.73%
		//guess leetcode did not have many bad cases where start and end are near the
		//first and last character
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int med=left+(right-left)/2;
            if(nums[med]==target){
                //WE FOUND NUM
                int r1=med;
                while(nums[r1]==target){
                    if(r1==0){
                        break;
                    }
                    r1--;
                }
                int r2=med;
                while(nums[r2]==target){
                    if(r2==nums.length-1){
                        break;
                    }
                    r2++;
                }
                if(nums[r1]!=target){
                    r1++;
                }
                if(nums[r2]!=target){
                    r2--;
                }
                return new int[]{r1,r2};
            }
            if(nums[med]<target){//it means target is to the right
                left=med+1;
            }else{//med is bigger than target, target is to the left
                right=med;
            }
        }
        if(nums[left]==target){
            return new int[]{left,left};
        }
        return new int[]{-1,-1};
    }
}

		//Leetcode's solution using binary search
		//
class Solution {
	

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }



    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

}