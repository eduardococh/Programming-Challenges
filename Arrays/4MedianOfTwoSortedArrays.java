        //Solution from leetcode's 2ms sample
        //Great explanation can be found in 
        //https://www.youtube.com/watch?v=LPFhl65R7ww
        //Amazing runtime better than 99% O(log(min(m,n)))
        //
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //if num1 is bigger invert them, nums1 must be the shortest array
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        //x will be smaller than y
        final int x = nums1.length;
        final int y = nums2.length;
        
        int start = 0, end = x;
        double res = 0;
        
        while(start <= end) {
            //X is the smaller array and Y the larger array
            
            //we will move partition x by one to the left or righted
            int partitionX = (start + end) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;
            
            //given partitions our max and mins will be partitionX,Y and both -1
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE: nums1[partitionX-1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE: nums1[partitionX];
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE: nums2[partitionY-1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE: nums2[partitionY];
            
            //if both max are bigger than min (we have found the middle point)
            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //the total number of elements is pair
                if((x + y) % 2 == 0) {
                    //take into account the two middle elements divided by 2
                    res = ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                    break;
                //total number of elements if odd
                } else {
                    //take the middle element
                    res = (double)(Math.max(maxLeftX, maxLeftY));
                    break;
                }
            } else if(maxLeftX < minRightY) {
                start = partitionX + 1;
            } else {
                end = partitionX - 1;
            }
        }
        return res;
        }
}