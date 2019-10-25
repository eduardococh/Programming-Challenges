		//My first solution 
		//Bad runtime better than only 55.61%
		//Bad memory better than only 12.20%
		//Trivial, usage of exception is not the most elegant 

class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0;
        try{
            while(nums[i]<target){
                i++;
            }
        }catch(Exception e){
            return nums.length;
        }
        return i;
    }
}

		//My binary search solution, way better 
		//Great runtime better than 100%
		//Great memory better than 92.1%
		
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while(low<high){
            int med=(high+low)/2;
            if(nums[med]>target){
                high=med;
            }else{
                low=med+1;
            }
            if(nums[med]==target){
                return med;
            }
        }
        if(target>nums[nums.length-1]){
            return nums.length;
        }
        return low;
    }
}

		//Leetcode's bruce.wu solution, litle bit simpler
        //
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}


        //My solution from 2nd try
        //With help from leetcode's AmmsA
        //Amazing runtime and memory better than 100% O(Log N)
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int middle=left+(right-left)/2;
            if(nums[middle]==target) return middle;
            if(nums[middle]<target){
                left=middle+1;
            }else{
                right=middle-1;
            }
        }
        return left;
    }
}