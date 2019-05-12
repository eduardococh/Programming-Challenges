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


		//My solution using queue, a more natural approach to this problem
		//Runtime of 1ms, better than 88.59%
		//Memory of 35.4 less than 80.5%
		//Good practice of a basic algorithm
class Solution {
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        Queue<TreeNode> treeQ=new LinkedList<TreeNode>();
        if(root!=null){
            treeQ.add(root);
        }
        while(!treeQ.isEmpty()){
            int levelLength=treeQ.size();
            List<Integer> thisLevel=new ArrayList<Integer>();
            for(int i=0;i<levelLength;i++){
                TreeNode current=treeQ.poll();
                thisLevel.add(current.val);
                if(current.left!=null){
                    treeQ.add(current.left);
                }
                if(current.right!=null){
                    treeQ.add(current.right);   
                }
            }
            result.add(0,thisLevel);
            
        }
        return result;
    }
    
}


		//Leetcode's SOY DFS approach
		//Same runtime and memory (small .1mb memory improvement over BFS)
		//Improvement over my ugly recursive solution
		//interesting the way he doesn't return anything in their method, only
		//alters object

public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {

        if(root == null) return;

        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }

        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);

    }
}
