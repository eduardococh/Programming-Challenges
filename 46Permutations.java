		//My solution, tought was going to be not so good but its really good
		//Great runtime 1ms better than 99.75%, O(n!)
		//Great memory 36.5mb better than 96% O(n!)
		//We use the list nums to save the nums that we have added and removed and currentList as the variable
		//that will generate the permutations through all the execution
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        ArrayList<Integer> intList = new ArrayList<>(nums.length);
        for (int i : nums)
        {
            intList.add(i);
        }
        generatePerm(intList,nums.length,new ArrayList<Integer>(),result);
        return result;
    }
    
    private static void generatePerm(ArrayList nums, int length,List<Integer> currentList,List<List<Integer>> result){
        if(currentList.size()==length){
            ArrayList<Integer> aux=new ArrayList<>();
            for(int i=0;i<currentList.size();i++){
                aux.add(currentList.get(i));
            }
            result.add(aux);
            return ;
        }
        
        for(int i=0;i<nums.size();i++){
            int aux=(int)nums.get(i);
            nums.remove(i);
            currentList.add(aux);
            generatePerm(nums,length,currentList,result);
            currentList.remove(currentList.size()-1);
            nums.add(i,aux);
        }
    }
}

		//A wayy more elegant solution	
		//Same runtime and memory as mine
		//The sample 0ms solution run in 1ms when i submitted, so i'll have this as the best one
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length == 0 ) return list;
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i <= tempList.size(); i++){
                tempList.add(i, nums[tempList.size()]);
                backtrack(list, tempList, nums);
                tempList.remove(i);
            } 
        }
    }
}