		//My solution using BFS
		//Great runtime at 0ms faster than 100%, runtime of O(V+E)
		//Great memory at 38.1mb, better than 70.95% O(V)
		//I think this is best than DFS
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int minLength=0;
        Queue<TreeNode> myQueue=new LinkedList<TreeNode>();
        myQueue.add(root);
        while(!myQueue.isEmpty()){
            int level=myQueue.size();
            minLength++;
            for(int i=0;i<level;i++){
                TreeNode current=myQueue.poll();
                if(current.left==null && current.right==null){
                    return minLength;
                }
                if(current.left!=null){
                    myQueue.add(current.left);    
                }
                if(current.right!=null){
                    myQueue.add(current.right);    
                }
            }
        }
        return 0;
    }
}


		//Recursive solution dfs,
		//Same runtime
		//.1 mb less in memory, better memory than mine
		//But for big enough trees bds will be better in general
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if (root.left == null && root.right != null)
          return right + 1;
        if (root.left != null && root.right == null)
          return left + 1;
        return Math.min(left, right) + 1;
    }
}