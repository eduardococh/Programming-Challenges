class Solution {
		//My solution ugly, middle runtime at 72%, runtime of o(n), where n is the total number of nodes
		//and bad memory at 36% and memory of o(n) 
		//Took me 1h10m because of wrong approachs, key is knowing a tree subtrees dont have to be symetric
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        String left=leftorder(root.left);
        String right=rightorder(root.right);
        if(left.equals(right)){
            return true;
        }else{
            return false;
        }
    }
    
    public String leftorder(TreeNode root){
        String result="";
        if(root==null){
            return "n";
        }
        result=result+root.val;
        result=result+leftorder(root.right);
        result=result+leftorder(root.left);
        return result;
    }
    
    public String rightorder(TreeNode root){
        String result="";
        if(root==null){
            return "n";
        }
        result=result+root.val;
        result=result+rightorder(root.left);
        result=result+rightorder(root.right);
        return result;
    }
    
}

		//Recursive approach, faster than 100% simple and elegant
		//Middle memory usage better than 48%
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }   
}

		//Iterative approach, more complex i think worse runtime than 77.84
		//but better memory than 92.31, its a tradeoff with recursive/iterative
public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    return true;
}