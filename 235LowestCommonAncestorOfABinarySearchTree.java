		//My solution, looong and not very elegant
		//Runtime of 5ms, better than 19.82% (Other 80% is in 4ms, best runtime) O(N)
		//Memory of 36.2mb, less than 5.01% O(N)
		//My big mistake was not considering that it is a binary search tree
		//Which by structure makes it easy to find target, my algorithm works for an unordered tree
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {   
        return new TreeNode(lowestCommonAncestorRec(root,p,q)[0]);
    }
    
    //first is number if found or -1, second if found 1 or not found 0
    public int[] lowestCommonAncestorRec(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){ 
            return new int[]{-1,0};
        }
        int left[]=lowestCommonAncestorRec(root.left,p,q);
        //System.out.println("for node "+root.val+" left is "+left[0]);
        if(left[1]==1){
            return left;
        }
        int right[]=lowestCommonAncestorRec(root.right,p,q);
        //System.out.println("for node "+root.val+" right is "+right[0]);
        if(right[1]==1){
            return right;
        }
        if((right[0]==p.val || right[0]==q.val)
          &&
           (left[0]==p.val || left[0]==q.val)){
            return new int[]{root.val,1};
        }
        //or im p
        if(root.val == p.val){
            if(right[0]==q.val){
                return new int[]{root.val,1};
            }
            if(left[0]==q.val){
                return new int[]{root.val,1};
            }
            return new int[]{p.val,0};
        }else{
            //or im q
            if(root.val == q.val){
                if(right[0]==q.val){
                    return new int[]{root.val,1};
                }
                if(left[0]==q.val){
                    return new int[]{root.val,1};
                }
                return new int[]{q.val,0};
            }     
        }
        if(left[0]!=-1){
            return new int[]{left[0],0};
        }
        if(right[0]!=-1){
            return new int[]{right[0],0};
        }
        return new int[]{-1,0};
    }
}

		//Recursive solution by leetcode DFS
		//Basically if p and q are bigger return right, else return left
		//and if p and q are not bigger or smaller (one is bigger the other smaller or our node it p or q)
		//we found the one, return it, this is the split point and theres only one for every pair of values, where
		//both p and q are not smaller or bigger, is 1 and 1
		//Good runtime  4ms better than 100% O(n)
		//Bad Memory of 36.6 less than 5.01% O(N), but this measure is tricky, i grabbed the supposed best runtime
		//from leetcode's samples and is gave me the same 5.01, not the expected 100%
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Value of current node or parent node.
        int parentVal = root.val;

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }
}


		//Leetcode's iterative solution
		//We dont need a queue like other tree iterative solutions because
		//the BST gives the solution very easily, like with recursive find the break point
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        // Start from the root node of the tree
        TreeNode node = root;

        // Traverse the tree
        while (node != null) {

            // Value of ancestor/parent node.
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return node;
            }
        }
        return null;
    }
}