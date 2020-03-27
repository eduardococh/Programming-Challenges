        //Dynamic programming solution as explained by Kevin Naughton Jr
        //Terrible runtime of 511ms better than only 5.12% O(N)
        //Terrible memory better than 6.35%
        //The backtracking solution can be inferred from this one
class Solution { 
    public boolean canPartition(int nums[]) {
        int total = 0; 
        for(int i: nums) { 
            total += i;
        }
        if(total % 2 != 0) {
            return false;
        }
        return canPartition(nums, 0, 0, total, new HashMap<String,Boolean>());
    }

    public boolean canPartition(int[] nums, int index, int sum, int total,HashMap<String,Boolean> state) {
        String current=index+""+sum;
        if(state.containsKey(current)) return state.get(current);
        if(sum * 2 == total) {
            return true;
        } 
        if(sum >total /2 || index >= nums.length) {
           return false; 
        }

        boolean status=canPartition(nums, index + 1, sum, total,state) || canPartition(nums, index + 1, sum + nums[index], total,state);
        state.put(current,status);
        return status;
    }
}