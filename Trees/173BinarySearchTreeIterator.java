/**
 *  My solution using mobile pointer, smallest/biggest variable and a stack of parents 
 *  Good runtime 16ms better than 84.73% O(1) for hasNext() and O(N) amortized to O(1)
 *  Amazing memory better than 100% O(h)
 *  A little too complex compared with other solutions but satisfied with it
 */
class BSTIterator {
    
    private Stack<TreeNode> parents;
    private TreeNode current;
    private int smallest;
    private int biggest;
    private TreeNode root;

    public BSTIterator(TreeNode root) {
        parents=new Stack<TreeNode>();
        current=new TreeNode(-1);
        smallest=-1;
        biggest=getBiggest(root);
        this.root=root;
    }
    
    /** @return the next smallest number */
    public int next() {
        if(current.val==-1) current=root;
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
        if(exploring.right!=null && exploring.right.val>smallest){
            parents.push(exploring);
            return exploreTree(exploring.right);
        }else{
            return exploreTree(parents.pop());
        }
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        //if(current==null) return false;
        return current.val==biggest?false:true;
    }
    
    private int getBiggest(TreeNode root){
        if(root==null) return -1;
        if(root.right==null) return root.val;
        return getBiggest(root.right);
    }
}


//Leetcode mentions the flatten tree approach, very simple but out of memory bounds
//Submitted it and it actually has same runtime and memory as my approach



/**
 * Stack approach, just brilliant and elegant
 * Interesting that it has bad runtime of 17ms, better than only 48.11% O(1) for has next
 * O(N) for worst scenario of next(), but amortized to O(1)
 * Amazing memory better than 100% O(h)
 */
class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        
        // Stack for the recursion simulation
        this.stack = new Stack<TreeNode>();
        
        // Remember that the algorithm starts with a call to the helper function
        // with the root node as the input
        this._leftmostInorder(root);
    }

    private void _leftmostInorder(TreeNode root) {
      
        // For a given node, add all the elements in the leftmost branch of the tree
        // under it to the stack.
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        // Node at the top of the stack is the next smallest element
        TreeNode topmostNode = this.stack.pop();

        // Need to maintain the invariant. If the node has a right child, call the 
        // helper function for the right child
        if (topmostNode.right != null) {
            this._leftmostInorder(topmostNode.right);
        }

        return topmostNode.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}