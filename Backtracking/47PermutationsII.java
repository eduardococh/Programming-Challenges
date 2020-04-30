        //My solution using hash set
        //SAME as permutations 1, only adding a visited set, if set contains list skip
        //Average runtime of 3ms better than 34.64% O(N^2)
        //Average memory better than 41.79% O(N)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        //Arrays.sort(nums);
        permuteUnique(nums,0,res,new HashSet<List<Integer>>(),new ArrayList<Integer>());
        return res;
    }
    
    private void permuteUnique(int[] nums,int index,List<List<Integer>> res,HashSet<List<Integer>> visited,List<Integer> soFar){
        if(soFar.size()==nums.length){
            res.add(new ArrayList<Integer>(soFar));
            return;
        }
        for(int i=0;i<=index;i++){
            soFar.add(i,nums[index]);
            if(visited.contains(soFar)){
                soFar.remove(i);
                continue;
            }
            visited.add(new ArrayList<Integer>(soFar));
            permuteUnique(nums,index+1,res,visited,soFar);
            soFar.remove(i);
        }
    }
}

        //From 1ms solutions
        //Trick to improve runtime is using a used boolean array instead of set, if I have used an address
        //mark it as visited
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true; 
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false; 
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}