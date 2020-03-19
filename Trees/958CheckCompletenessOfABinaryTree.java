
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        int height=getHeight(root);
    	return checkTotal(root,height-1);
    }
        
    public int checkTotal(TreeNode node, int height){
        if(checkTotal(node.left,height-1)=0){
            
        }
    }
}