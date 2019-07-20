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
    public int pathSum(TreeNode root, int sum) {
        return pathCounter(root,sum,0,0,true);
    }
    
    public int pathCounter(TreeNode root,int sum, int result, int soFar,boolean first){
        if(root==null) return result;
        //System.out.println("We are in "+root.val);
        soFar+=root.val;
        if(soFar==sum) {
            //System.out.println("in node "+root.val);
            result++;
        }
        result=pathCounter(root.right,sum,result,soFar,false);
        result=pathCounter(root.left,sum,result,soFar,false);
        if(first){
            result=pathCounter(root.right,sum,result,0,true);
            result=pathCounter(root.left,sum,result,0,true);
        }
        return result;
    }
}