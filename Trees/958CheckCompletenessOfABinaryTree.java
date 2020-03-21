/*My messy solution
  Not clear, but it works
  Do an inorder traversal and check for every node a lot of conditions
  Amazing runtime of 0ms better than 100% O(N)
  Terrible memory better than only 7%
*/
class Solution {
    
    boolean decrease;
    int height;
    
    public boolean isCompleteTree(TreeNode root) {
        height=setHeight(root);
        decrease=false;
    	return checkTree(root,1);
    }
        
    public boolean checkTree(TreeNode node,int currHeight){
        if(node==null) return true;
        if(node.left==null && node.right==null && ((!decrease && currHeight==height) || currHeight==height-1)){//leaf
            if(height-1==currHeight) decrease=true;
            return true;
        }
        if(node.left!=null && node.right!=null){
            if(!checkTree(node.left,currHeight+1)) return false;
            if(!checkTree(node.right,currHeight+1)) return false;    
            return true;
        }
        if(currHeight==height-1){
            if(node.left==null && node.right!=null) return false;
            if(node.right==null && node.left!=null && !decrease){
                decrease=true;
                return true;
            }    
        }
        //a node not in height-1 cant have any empty nodes
        return false;
    }
    
    public int setHeight(TreeNode root){
        int height=0;
        while(root!=null){
            root=root.left;
            height++;
        }
        return height;
    }
}

/*
    Queue solution, explained by juanbensa
    Code from sample 0ms solutions
    Same runtime and memory as my solution 
    Genius, put all nodes into a queue, a breadth first search (BFS)
    If you find a null node, then all nodes forward should be null
    If you find another node that is not null it means the tree is not complete
    We take advantage of the fact that the queue with linkedlist allows for null insertion
*/
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                break;
            } else {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        while (!queue.isEmpty()) {
            if (queue.poll() != null) return false;
        }
        return true;
    }
}

/*Leetcode proposes a solution that assigns values to every node, so it will be 1 for the first
two for left child and three for right child, as noted by many users it is complicated compared with
other methods so not worth it*/