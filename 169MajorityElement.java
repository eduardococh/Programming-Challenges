		//My solution using hashmap
		//Terrible runtime at 19ms faster than only 8%
		//Great memory at 39mb less than 98%
		//Simple approach, but maybe hashmap is an overkill
		//There are a lot of approaches in this problem's article, ill only cover some
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> values=new HashMap<>();
        int currentMax=0;
        int result=0;
        for(int i=0;i<nums.length;i++){
            if(values.containsKey(nums[i])){
                values.put(nums[i],values.get(nums[i])+1);
            }else{
                values.put(nums[i],1);
            }
            if(values.get(nums[i])>currentMax){
                currentMax=values.get(nums[i]);
                result=nums[i];
            }
        }
        return result;
    }
}

		//Sorting approach
		//Best runtime at 0ms, better than 100% run in O(log(n))
		//Average memory at 41mb better than 50%
		//Very clear and readable, best one for me
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}