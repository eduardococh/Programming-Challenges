/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    
    private Stack<TreeNode> parents;
    private TreeNode current;
    private int smallest;
    private int biggest;
    private TreeNode root;

    public BSTIterator(TreeNode root) {
        parents=new Stack<TreeNode>();
        current=root;
        smallest=-1;
        biggest=getBiggest(root);
        this.root=root;
    }
    
    /** @return the next smallest number */
    public int next() {
        return exploreTree(current);
    }
    
    private int exploreTree(TreeNode exploring){
        if(exploring.left!=null && exploring.left.val>smallest){
            parents.push(exploring);
            return exploreTree(exploring.left);
        }
        if(exploring.val>smallest) {
            current=exploring;
            smallest=exploring.val;
            return exploring.val;
        }
        if(exploring.right==null){
            return exploreTree(parents.pop());
        }else{
            parents.push(exploring);
            return exploreTree(exploring.right);
        }
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(root.left==null && root.right==null) return false;
        return current.val==biggest?false:true;
    }
    
    private int getBiggest(TreeNode root){
        if(root.right==null) return root.val;
        return getBiggest(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */