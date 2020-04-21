/*
    My initial solution using recursion and returning max and min
    Amazing runtime of 0ms better than 100% O(N)
    Bad memory better than only 6.90% O(N)
    Good solution that I clearly understand, leetcode offers a shorter one
    and better one I think
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        Node tails[]=transformNodes(root);
        tails[0].left=tails[1];
        tails[tails.length-1].right=tails[0];
        return tails[0];
        
    }
    
    
    public Node[] transformNodes(Node node){
        if(node==null) return null;
        Node left[]=transformNodes(node.left);//i want the biggest value to my left
        Node right[]=transformNodes(node.right);//i want the smallest value to my right
        //position 0 will have the smallest value, position 1 will have the biggest value
        if(left!=null){//i will link to the biggest value of my left
            node.left=left[1];
            left[1].right=node;
        }
        if(right!=null){//i will link to the smallest value of my right
            node.right=right[0];
            right[0].left=node;
        }
        Node result[]=new Node[2];
        //populate the space for the smallest value of subtree, the smallest of my left or me
        if(left==null){
            result[0]=node;
        }else{
            result[0]=left[0];
        }
        if(right==null){
            result[1]=node;
        }else{
            result[1]=right[1];
        }
        return result;
    }
}

    //Recursive solution by leetcode
    //Same runtime and memory as my solution
    //Just simple and elegant, depending on what you think of using global variables
class Solution {
  // the smallest (first) and the largest (last) nodes
  Node first = null;
  Node last = null;

  public Node treeToDoublyList(Node root) {
    if (root == null) return null;

    helper(root);
    // close DLL
    last.right = first;
    first.left = last;
    return first;
  }

  public void helper(Node node) {
    if (node != null) {
      // left
      helper(node.left);
      // node 
      if (last != null) {
        // link the previous node (last)
        // with the current one (node)
        last.right = node;
        node.left = last;
      } else {
        // keep the smallest node
        // to close DLL later on
        first = node;
      }
      last = node;
      // right
      helper(node.right);
    }
  }
}