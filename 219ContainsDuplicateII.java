		//My solution
		//Average good runtime at 8ms better than 80.71% O(N)
		//Average memory at 42.2mb better than 59.45% O(N)
		//Good to know method numberMapping.putIfAbsent() that i didn't know
		//A solution that works, easy to understand but not best runtime or memory
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> numberMapping=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(numberMapping.containsKey(nums[i])){
                if(Math.abs(numberMapping.get(nums[i])-i)<=k){
                    return true;
                }else{
                    numberMapping.put(nums[i],i);
                }
            }else{
                numberMapping.put(nums[i],i);
            }
        }
        return false;
    }
}

		//Brute force solution
		//From leetcode's 0ms sample
		//Great runtime at 0ms faster than 100% o(n)
		//Great memory at 39.4mb less than 96.41%
		//Apparently there's only one case where the length of nums is bigger than 5000, the case where my own
		//brute force solution time limit excedeed, so this is a valid solution, but not the best
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       if(nums.length==0) return false;
        if(nums.length>=5000) return false;   //HARDED CODED TO PASS A TESTCASE whose nums length is 55400
        
	for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i==j) continue;
                if(nums[i]==nums[j]){
                    if(Math.abs(i-j)<=k){
                        return true;
                    }
                }
            }
        }
	return false;
    }
}

		//Solution by leetcode's southpenguin
		//Sliding window
		//
		//Good runtime at 6ms, better than 97.88%, while there were faster solutions they involved the brute force cheat
		//or they where complex, so this is the faster, simpler solution, O(N)
		//Average memory at 41.6 mb better than 67% o(n) 

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){

	    //remove the last element of the set when the set is bigger than k
            if(i > k) set.remove(nums[i-k-1]);

	    //if add returns false, it means the number already exists in the set (whose window is from i to i-k) so the condition is true
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
