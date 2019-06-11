
		//My solution
		//Amazing runtime at 0ms better than 100% but O(N)
		//Amazing memory at 37.1mb, better than 99.98% O(1)
		//Definetly will solve, but might be better?
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                return i;
            }
        }
        return 0;
    }
}

		//Leetcode's recursive binary search solution, 
		//Amazing runtime at 0ms O(LOG(N)), with big enough cases this will beat mine
		//But in problems comments many question the proof of this solution
		//But to me is pretty obvious once you look at the problem like just
		//lines going up and down, where binary search just accelerates it
		//changed leetcode's buggy middle search with right one
		//
public class Solution {
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = l + ((r - l) / 2);
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }
}


		//Leetcode's iterative solution, more like the one i know
		//If mid is bigger than mid+1 means peak is to the left
		//if mid is smaller than mid+1 means peak is to the right
		//do while l<r
		//Pretty much like a normal binary search (if we consider the numbers
		//kinda sorted in peaks going up and down)
public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}