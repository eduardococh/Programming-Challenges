        //My solution
        //Usage of an algorithm like the one in EPI, but less elegant
        //The book uses an STATUS OBJECT which makes the code more elegant and readable
        //The algorithm is much like mine but it improves a lot
        //Average runtime of 6ms better than 64.11%
        //Bad memory better than only 5% (couldn't get any program better than this)
        //Not the most elegant but not bad
        //Usage of objects instead of arrays should be more used
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findHelper(root,p,q,0)[0];
    }
    
    public TreeNode[] findHelper(TreeNode root,TreeNode p, TreeNode q,int foundNodes){
        if(root==null){
            return new TreeNode[]{root,new TreeNode(0)};
        }
        
        TreeNode[] left=findHelper(root.left,p,q,0);
        if(left[1].val==2){
            return new TreeNode[]{left[0],new TreeNode(left[1].val)};
        }
        foundNodes+=left[1].val;

        TreeNode[] right=findHelper(root.right,p,q,0);
        if(right[1].val==2){
            return new TreeNode[]{right[0],new TreeNode(right[1].val)};
        }
        foundNodes+=right[1].val;
        
        if(root.val==p.val){
            foundNodes++;
        }
        if(root.val==q.val){
            foundNodes++;
        }
        //System.out.println("im in r root "+root.val+" "+foundNodes);
        return new TreeNode[]{root,new TreeNode(foundNodes)};
    }
}


        //From leetcode's 5ms samples
        //Brilliant logic, basically if im p or q I return myself, otherwise if left and right are
        //not null it means im the LCA, and for all else nodes either left or right will be null
        //meaning you return only p, q or the LCA
        //Amazing runtime of 5ms better than 100%
        //Bad memory less than 5%
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p ,q );
        TreeNode right = lowestCommonAncestor(root.right, p ,q );
        
        if(left != null && right != null) return root;

        //this could return null anyway
        return left == null ? right : left;
    }
}
        //Same approach as above but with my own logic
        //Same amazing runtime and memory
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        
        if(root.val==p.val || root.val==q.val){
            return root;
        }
        
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        
        if(left!=null && right!=null) return root;
        
        if(left!=null) return left;
        if(right!=null) return right;
        
        
        return null;
    }
}


        //Iterative solution
        //Great logic, iterate through the three until we find p and q and for every
        //node create a parent set using a map of treeNode-treeNode (constant access), 
        //when both are found create a set with the parent way of p and then go through
        //the parent set of q and the first coincidence is the result
        //Bad runtime at 12 ms better than 15.20%
        //Bad memory better than 5%
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();

        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }

}