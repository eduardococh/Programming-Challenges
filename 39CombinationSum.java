class Solution {
    
    private int length;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        HashSet<ArrayList<Integer>> mySet=new HashSet<ArrayList<Integer>>();
        length=candidates.length;
        generateCombinations(candidates,target,mySet,new ArrayList<Integer>(),0,0);
        for(ArrayList<Integer> arr:mySet){
            result.add(arr);
        }
        return result;
    }
    
    public void generateCombinations(int[] candidates, int target,HashSet<ArrayList<Integer>> mySet,List<Integer> currentComb,int sumSoFar,int start){
        if(sumSoFar==target){
            mySet.add(new ArrayList(currentComb));
            return;
        }
        if(sumSoFar>target){
            return;
        }
        for(int i=start;i<length;i++){
            currentComb.add(candidates[i]);
            sumSoFar+=candidates[i];
            generateCombinations(candidates,target,mySet,currentComb,sumSoFar,i);
            currentComb.remove(currentComb.size()-1);
            sumSoFar-=candidates[i];
        }
    }
}