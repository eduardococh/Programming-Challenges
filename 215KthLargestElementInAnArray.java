		//My solution
		//Easy solution, use java default sorting (quicksort)
		//Good runtime of 3ms better than 76% of solutions
		//Good memory of 38.1mb better than 58.04%
		//It works and is good enough
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length<k) return -1;
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

		//Quickselect solution from leetcode's sample 0ms
		//Amazing runtime of 0ms better than 100%
		//Great memory of  36.5mb better than 94.63%
		//
class Solution {
   public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length - 1);
    }
    
    int quickSelect(int[] nums, int k, int start, int end) {
        if (start == end) return nums[start];
        int left = start;
        int right = end;
        int pivot = nums[start + (end - start) / 2];
        while (left < right) {
            while (left <= right && nums[left] > pivot) left++;
            while (left <= right && nums[right] < pivot) right--;
            if (left <= right) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;                
            }
        }
        
        if (start + k - 1 <= right) {
            return quickSelect(nums, k, start, right);
        }
        
        if (start + k - 1 >= left) {
            return quickSelect(nums, k - (left - start),  left, end);
        }
        
        return nums[right + 1];
    }
    
}