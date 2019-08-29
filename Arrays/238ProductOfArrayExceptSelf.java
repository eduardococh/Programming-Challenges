        //My recursive approach, not the best for this problem, usage of recursion stack
        //makes it slow and memory consuming, better to use only normal arrays (even the 
        //approach that uses left and right array makes it faster)
        //Bad runtime at 3ms better than 12.80%
        //Bad memory at 46.4 mb better than 5.51%
        //IMPORTANT NOTES:
        //DO NOT CONFUSE USING I++, IT MODIFIES THE VARIABLE, USE I+1 WHEN YOU
        //DON'T WANT TO MODIFY
class Solution {
    
    private int length;
    
    public int[] productExceptSelf(int[] nums) {
        int result[]=new int[nums.length];
        length=nums.length;
        multiplicator(result,nums,1,0);
        return result;
    }
    
    public int multiplicator(int result[],int[] nums,int left,int index){
        //System.out.println("we enter "+index+" r "+right+" l "+left);
        if(index==length){
            return 1;
        }
        int right=1;
        right=multiplicator(result,nums,left*nums[index],index+1);
        //System.out.println("we enter "+index+" r "+right+" l "+left);
        result[index]=right*left;
        return right*nums[index];
    }
}


        //Leetcode's solution using constant space (there's a solution using left and right
        //arrays, but it's not worth covering)
        //Here our answer array does not count to memory limit, so its O(1)
        //First loop array from 0 to length and use answer as left result
        //then loop from length to 0, using results in left and a variable
        //right, kinda like what I did with recursion
        //Best runtime than 100%
        //Best memory than 100%
class Solution {
    public int[] productExceptSelf(int[] nums) {

        // The length of the input array 
        int length = nums.length;

        // Final answer array to be returned
        int[] answer = new int[length];

        // answer[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the answer[0] would be 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {

            // answer[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all 
            // elements to the left of index 'i'
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R would be 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {

            // For the index 'i', R would contain the 
            // product of all elements to the right. We update R accordingly
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
    }
}