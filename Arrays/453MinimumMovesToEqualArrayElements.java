        //Solution and explanation by leetcode's kdtree
        //Adding 1 to n - 1 elements is the same as subtracting 1 from one element, 
        //w.r.t goal of making the elements in the array equal.
        //So, best way to do this is make all the elements in the array equal to the min element.
        //sum(array) - n * minimum 
        //
public class Solution {
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        for (int n : nums) res += n - min;
        return res;
    }
}

        //From 1ms solution samples
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(nums[i] < min){
                min = nums[i];
            }
        }
        return sum-min*nums.length;
    }
}