        //My bad solution
        //Bad runtime of 24ms better than only 22% O(N log(n))
        //Average memory O(1)
        //Sort the array and then run through n numbers
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<Integer>();
        Arrays.sort(nums);
        int cont=1,i=0;
        while(i<nums.length){
            while(cont<nums[i]){
                result.add(cont);
                cont++;
            }
            while(i<nums.length && cont==nums[i]){
                i++;
            }
            cont++;
        }
        while(cont<=nums.length){
            result.add(cont);
            cont++;
        }
        return result;
    }
}

        //From leetcode's 6ms solution
        //Smart approach, no extra memory
        //Do one loop over nums, negate the index which this number points and then 
        //add to result the positive indexes
        //Example 4, 3, 2, 7, 8, 2, 3, 1
        //result -4,-3,-2,-7, 8, 2,-3,-1
        //Very clever, it follows the problem rules of linear time and constant memory
        //Good runtime of 6ms better than 79.80% O(N)
        //Good memory of 48.2mb O(1) 
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        
        return result;
    }
}