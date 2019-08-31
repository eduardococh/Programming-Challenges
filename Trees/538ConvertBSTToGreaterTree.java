/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode convertBST(TreeNode root) {
        doSum(root,0);
        return root;
    }
    
    public int doSum(TreeNode root, int sum){
        if(root==null) return sum;
        sum=doSum(root.right,sum)+root.val;
        root.val=sum;
        return doSum(root.left,sum);
    }
}