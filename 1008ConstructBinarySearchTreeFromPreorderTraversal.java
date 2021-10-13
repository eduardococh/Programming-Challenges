/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,new int[]{0},preorder[0]);
    }
    
    public TreeNode bstFromPreorder(int[] preorder,int[] index,int parent){
        if(index[0]>=preorder.length) return null;
        //first item is root
        TreeNode root=new TreeNode(preorder[index[0]]);
        index[0]++;
        
        //if next is smaller, that is left son
        if(index[0]<preorder.length && preorder[index[0]]<root.val){
            root.left=bstFromPreorder(preorder,index,root.val);
        }else
        //next is not smaller, check if my parent is also smaller than next
        if(index[0]<preorder.length && preorder[index[0]]<parent){
            //my parent is also smaller than index[0], this node must be right child of parent
            return root;
            
        }//
        //continue whatever you need to do to the right
        if(index[0]<preorder.length){
            root.right=bstFromPreorder(preorder,index,root.val);   
        }
        return root;
    }
}