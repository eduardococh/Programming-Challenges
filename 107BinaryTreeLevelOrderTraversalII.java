		//My ugly, bad solution
		//Runtime better than only 10%
		//Memory better than 80%
		//Usage of exception was not the most clever implementation
		//But got the job done
class Solution {
    
    int max=-1;
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        return createList(result,root,0);
    }
    
    public List<List<Integer>> createList(List<List<Integer>> result, TreeNode root, int level){
        if(root==null){
            return result;
        }
        try{
            result.get(level);
            result.get(max-level).add(root.val);
        }catch(IndexOutOfBoundsException iobe) {
            result.add(0,new ArrayList<Integer>(Arrays.asList(root.val)));
            max++;
        }
        result=createList(result,root.left,level+1);
        result=createList(result,root.right,level+1);
        return result;
    }
}