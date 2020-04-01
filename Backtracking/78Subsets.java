		//My solution
		//This problem was great learning of what backtracking really is, like
		//the parenthesis problem i started going from a big solution to a small one and
		//that just doesn't work so easily (but doable i guess), backtracking is
		//starting from a small solution and get it bigger, checking if a newly generated
		//solution is valid, if yes generate more based on this, if no go to next
		//which is basically what i did here, 
		//Bad runtime of 7ms, better than only 5-6% o(N) IT'S NOT O(N)
        //As explained in CTCInterview, the best time and memory complexity possible is O(N2^N)
		//Amazing memory less than 99.1%
		//Mixed result with bad runtime

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> temp=new ArrayList<>();
        result.add(new ArrayList(temp));
        generateResult(temp,result,nums,0);
        return result;
    }
    
    public void generateResult(List<Integer> temp,List<List<Integer>> result,int[] nums,int start){
        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            if(!result.contains(temp)){
                result.add(new ArrayList(temp));
                generateResult(temp,result,nums,++start);
            }
            temp.remove(temp.size()-1);
        }
    }
}

		//Amazingly simple improvement over original approach'
		//Remove if as its not necessary (result will never contain temp since we move start up)
		//Amazing runtime better than 100% O(
		//98.91 mem
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        generateResult(new ArrayList(),result,nums,0);
        return result;
    }
    
    public void generateResult(List<Integer> temp,List<List<Integer>> result,int[] nums,int start){
        result.add(new ArrayList(temp));
        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            generateResult(temp,result,nums,++start);
            temp.remove(temp.size()-1);
        }
    }
}

        //Recursive solution
        //Amazing runtime of 0ms better than 100% O(N*2^N)
        //This is because the total number of sets will be 2^N
        //And for 2^N subsets, every element of the original set will be present in half subsets
        //So this give us N*2^N
        //Bad memory better than only 5.74 O(N*2^N)
        //
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        createSubsets(result,nums,0,new ArrayList<Integer>());
        return result;
    }
    
    public void createSubsets(List<List<Integer>> result, int[] nums,int current, ArrayList<Integer> soFar){
        if(current>nums.length) return;
        if(current==nums.length){
            //NOTE ALWAYS RETURN IN STOP CONDITION, DO NOT FORGET
            result.add(new ArrayList(soFar)); 
            return;
        }
        createSubsets(result,nums,current+1,soFar);
        soFar.add(nums[current]);
        createSubsets(result,nums,current+1,soFar);
        //NOTE LISTS ARE REMOVED BY INDEX, NOT VALUE, since we're giving an int
        //Delete by value works with objects, but int is not an object
        soFar.remove(soFar.size()-1);
    }
}