		//My solution
		//Not soooo bad but not good, the basic approach (backtracking) is the same than in better solutions (like 1ms solution)
		//Bad runtime of 6ms better than 28.86% O(k * 2 ^ n)
		//Average memory better than 43.86% 
		//Can be improved
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



		//Leetcode's sample 2ms solution,
		//My same approach but way better in implementation
		//Amazing runtime of 2ms better than 98.87%
		//Amazing memory better than 99.76%
		//Same approach to solution as me, but better done
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    
  List<List<Integer>>result=new ArrayList<>();
   if(candidates.length==0 || candidates==null){
     return result;
   }   
      Arrays.sort(candidates);
    List<Integer>combination=new ArrayList<>();
      
    dfs(result,combination,candidates,target,0);  
      return result;  
    }
  
  public void   dfs(List<List<Integer>>result,List<Integer>combination,int []candidates,int target,int startindex){
    
   if(target==0){
     result.add(new ArrayList<>(combination));
     return;
   } 
    
    for(int i=startindex;i<candidates.length;i++){
      if(candidates[i]>target){
        break;
      }
      combination.add(candidates[i]);
      dfs(result,combination,candidates,target-candidates[i],i);
      combination.remove(combination.size()-1);
    }
    
  }
  
  
  
  
}