/*
    My solution using partition in half
    Calculate height of tree except for the last level
    last level height is calculated by checking if the subtrees are complete
    this way for every level we remove half of the tree, making the algo
    fast
    Amazing runtime of 0ms better than 100% O(Log N)
    Bad memory only better than 9% O(H) where H is the height of the tree
*/
class Solution {
    
    int height;
    int total;
    
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        height=getHeight(root,false);
        total=(int)Math.pow(2,height-1)-1;
        checkLength(root,height);
        return total;
    }
    
    public void checkLength(TreeNode node, int currHeight){
        if(getHeight(node,true)==currHeight){//subtree is complete
            total+=(int)Math.pow(2,currHeight-1);
        }else{//check both subtrees
            if(node.left!=null)checkLength(node.left,currHeight-1);
            if(node.right!=null)checkLength(node.right,currHeight-1);
        }
    }
    
    public int getHeight(TreeNode root,boolean direction){
        int height=0;
        if(direction){
            while(root!=null){
                root=root.right;
                height++;
            }
        }else{
            while(root!=null){
                root=root.left;
                height++;
            }
            
        }
        return height;
    }
}