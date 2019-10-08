        //Recursive solution from leetcode
        //In every deleteNode recursion there are 4 posibilities, we go right or left and keep searching
        //or the key does not exist, so we do nothing, or we find our result
        //we conl
class Solution {

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;

    // search process, delete from the right subtree
    if (key > root.val) root.right = deleteNode(root.right, key);
    // search process, delete from the left subtree
    else if (key < root.val) root.left = deleteNode(root.left, key);
    // delete the current node
    else {
        //WE FOUND OUR RESULT, STOP RECURSION AND DO FINAL PROCESSING
      // if the node is a leaf
      if (root.left == null && root.right == null) root = null;
      // else if the node is not a leaf and has a right child
      else if (root.right != null) {
          //FIND SUCESSOR
        root.val = successor(root);
          //DELETE SUCESSOR (IT IS SAVED IN ROOT VAL)
        root.right = deleteNode(root.right, root.val);
      }
      // else if the node is not a leaf, has no right child, and has a left child    
      else {
        root.val = predecessor(root);
        root.left = deleteNode(root.left, root.val);
      }
    }
    return root;
  }

  /*
  One step right and then always left
  */
  public int successor(TreeNode root) {
    root = root.right;
    while (root.left != null) root = root.left;
    return root.val;
  }

  /*
  One step left and then always right
  */
  public int predecessor(TreeNode root) {
    root = root.left;
    while (root.right != null) root = root.right;
    return root.val;
  }
}

        //My UGLYYY iterative solution, not worth viewing and only for personal record
        //Amazing runtime of 0ms better than 100% O(M) where M is length of path to node in N total nodes
        //Amazing memory better than 100% O(M)
        //Good runtime and memoru
class Solution {
  
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val==key && root.left==null && root.right==null) return null;
        if (root.val==key && root.left!=null && root.right==null) return root.left;
        if (root.val==key && root.left==null && root.right!=null) return root.right;
        
        TreeNode iterator=root;
        TreeNode parent=root;
        boolean direction=false;
        while(iterator.val!=key){
            parent=iterator;
            if(iterator.val<key){
                direction=true;
                iterator=iterator.right;
            }else{
                direction=false;
                iterator=iterator.left;
            }
            if(iterator==null) return root;
        }
        //Case 1: both children of node are null
        if(iterator.left==null && iterator.right==null){
            if(direction){
                parent.right=null;
            }else{
                parent.left=null;
            }
            return root;
        }
        //case 2:right is not null
        if(iterator.right!=null  && iterator.left==null){
            if(direction){
                parent.right=iterator.right;
            }else{
                parent.left=iterator.right;
            }
            return root;
        }
        //case 2:left is not null
        if(iterator.left!=null && iterator.right==null){
            if(direction){
                parent.right=iterator.left;
            }else{
                parent.left=iterator.left;
            }
            return root;
        }
        
        //case 3: none is null
        //assign right leftmost node
        TreeNode leftmost=iterator.right;
        TreeNode LMParent=iterator;
        direction=true;
        while(leftmost.left!=null){
            direction=false;
            LMParent=leftmost;
            leftmost=leftmost.left;
        }
        iterator.val=leftmost.val;
        if(leftmost.right!=null){
            if(direction){
                LMParent.right=leftmost.right;    
            }else{
                LMParent.left=leftmost.right;
            }
        }else{
            if(direction){
                LMParent.right=null;    
            }else{
                LMParent.left=null;
            }
        }
      
        return root;
    }
}