        //My solution
        //Bad runtime O(N) better than only 23%
        //Bad memory
        //Basically do an inorder traversal, when you find the node 
        //go get the next node in the traversal
        //It is a bad solution because we do not use the BST property of
        //natural ordering, left are smaller right are bigger
        //My code will go through nodes in a traversal, which is not needed
        //as it can be seen in the second solution, which goes straight to the solution
class Solution {
    
    class SearchStatus{
        boolean status;//0 not found|found and assigned, 1 previous is q
        TreeNode result;
        
        public SearchStatus(boolean status,TreeNode result){
            this.status=status;
            this.result=result;
        }
    }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return sucessorHelper(root,p,false).result;
    }
    
    public SearchStatus sucessorHelper(TreeNode root,TreeNode p,boolean found){
        if(found==true){
            if(root==null){
                return new SearchStatus(false,root);//root could be null, meaning there's no sucessor
            }else{
                if(root.left!=null){
                    return sucessorHelper(root.left,p,true);//our leftmost children is sucessor
                }else{
                    return new SearchStatus(false,root);//we do not have children, we are sucessor
                }
            }
        }
        if(root==null) return null;
        if(root.val==p.val){
            if(root.right==null){
                return new SearchStatus(true,null); //we found q and there's no right        
            }else{
                return sucessorHelper(root.right,p,true);
            }
        }
        
        SearchStatus left=sucessorHelper(root.left,p,false);
        //if(left!=null)  System.out.println("for node "+root.val+" left is "+left.result+" "+left.status);
        if(left!=null && left.result!=null) return left;
        if(left!=null && left.status==true) return new SearchStatus(false,root);
        
        SearchStatus right=sucessorHelper(root.right,p,false);
        if(right!=null && right.result!=null) return right;
        //Its not possible for root to be sucessor of right child, only return if found
        if(right!=null && right.status==true) return new SearchStatus(true,null);
        
        return new SearchStatus(false,null);
    }
}

        //Leetcode's solution, here we consider two scenarios
        //one, p has right child, so the leftmost of this right child is our answer
        //two, p has not right child, so we do an inorder traversal (like in my solution)
        //and save the traversal in a stack, when 
class Solution {
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    // the successor is somewhere lower in the right subtree
    // successor: one step right and then left till you can
    if (p.right != null) {
      p = p.right;
      while (p.left != null) p = p.left;
      return p;
    }

    // the successor is somewhere upper in the tree
    ArrayDeque<TreeNode> stack = new ArrayDeque<>();
    int inorder = Integer.MIN_VALUE;

    // inorder traversal : left -> node -> right
    while (!stack.isEmpty() || root != null) {
      // 1. go left till you can
      while (root != null) {
        stack.push(root);
        root = root.left;
      }

      // 2. all logic around the node
      root = stack.pop();
      // if the previous node was equal to p
      // then the current node is its successor
      if (inorder == p.val) return root;
      inorder = root.val;

      // 3. go one step right
      root = root.right;
    }

    // there is no successor
    return null;
  }
}

        //From leetcode's 0ms samples
        //Super simple and elegant solution
        //Amazing runtime 2ms O(N) better than 100%
        //Go to node, if node is smaller or equal than p return the sucessor of right
        //if node is bigger than p go to the left 
        //
class Solution {
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return successor(root, p);
    }

    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null) return null;

        if (root.val <= p.val) {
            return successor(root.right, p);
         } else {
            TreeNode left = successor(root.left, p);
            return (left != null) ? left : root;
          }
    }
}