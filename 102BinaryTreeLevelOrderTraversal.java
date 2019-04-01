class Solution {
		//My solution, recursive, 0ms better than 100%, memory 37.4mb better than 22%, clear implementation
		//It is DepthFirstSearch solution
		
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<List<Integer>>();
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        return traverse(result,root,0);
    }
    
    private List<List<Integer>> traverse(List<List<Integer>> result, TreeNode root,int level){
        if(result.size()==level){
            List<Integer> newList=new ArrayList<Integer>();
            newList.add(root.val);
            result.add(newList);   
        }else{
            result.get(level).add(root.val);
        }
        if(root.left!=null){
            result=traverse(result,root.left,level+1);
        }
        if(root.right!=null){
            result=traverse(result,root.right,level+1);
        }
        return result;
    }
}

	//Little clearer DFS, same memory and time
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrderHelper(list, 0, root);
        return list;
    }
    
    private void levelOrderHelper(List<List<Integer>> list, int level, TreeNode root) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        levelOrderHelper(list, level + 1, root.left);
        levelOrderHelper(list, level + 1, root.right);
    }
}

		//Java solution using BFS breadth first search by leetcode caikehe, more clear than all other
		//Runtime of 1ms, faster than 74.75%, 37.3 MB, better than 76%		

public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    List<List<Integer>> ret = new ArrayList<>();
    //This outer loop will run once per every level
    while (!queue.isEmpty()) {
        int l = queue.size();
        List<Integer> level = new ArrayList<>();
	//This inner loop will run once per every node in this level (4 times for a level of 4 nodes)
        for (int i = 0; i < l; i++) {
            TreeNode node = queue.poll(); 
            if (node != null) {
                level.add(node.val);
		//This will add null values to the queue, the if above will solve that
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        if (!level.isEmpty()) {
            ret.add(level);
        }
    }
    return ret;
}

