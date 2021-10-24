        //Solution by leetcode's GraceMeng
        //Amazing runtime better than 100% O(N)
        //Good runtime better than 62.50% O(N)

        //EXPLANATION by GraceMeng

        /*If we split the array with mi into [lo, mi] and [mi, hi].
        
         If [mi, hi] is not sorted, 
          min must be within (mi, hi] - since we detect [mi, hi] is not sorted by nums[mi] > nums[hi], 
          nums[mi] cannot be min. 

          
         If [lo, mi] is not sorted, 
         since we detect [lo, mi] is not sorted by nums[lo] > nums[mi] so nums[lo] cannot be min,
        min must be within (lo, mi]. 
          
         If they are both sorted, nums[lo] is the min.
        */
class Solution {
     public int findMin(int[] nums) {
        
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            //Is [mi,hi] not sorted?
            if (nums[mi] > nums[hi]) { 
                lo = mi + 1; //not sorted, min must be from mi+1 to high
            }
            //is [lo,mi] not sorted
            else if (nums[mi] < nums[lo]) { 
                hi = mi; //not sorted, min will be in [lo+1,mi], hi=mi
                lo++; //add one to lo since lo can not be min
            }
            //neither is sorted
            else { // nums[lo] <= nums[mi] <= nums[hi] 
                hi--; //hi is not min
            }
        }
        //break when lo==hi
        return nums[lo];
    }
}

//Attempt using binary search, no success, hit a wall with TC [10,1,10,10,10]
class Solution {
    public int findMin(int[] nums) {
        if(nums[0]>=nums[nums.length-1]){
            //the minimum could be from 1 to N-1
            //array is rotated
            int left=0,right=nums.length-1;
            while(left+1<right){//we should at least have three
                int mid=left+(right-left)/2;
                System.out.println(left+" "+mid+" "+right);
                if(nums[mid-1]>nums[mid]) return nums[mid];
                if(left>0 && nums[left-1]>nums[left]) return nums[left];
                if(nums[left]<=nums[mid]){
                    //min is to the right
                    left=mid+1;
                }else{
                    //min is to the left
                    right=mid-1;
                }                                                             
            }
            System.out.println(left+" "+right);
            return nums[left]<nums[right]?nums[left]:nums[right];
        }else{
            //the minimum is at 0
            return nums[0];
        }
    }
}