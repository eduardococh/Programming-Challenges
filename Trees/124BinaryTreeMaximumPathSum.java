        //My solution using recursion
        //Amazing runtime of 1ms better than 99.82% O(N)
        //Amazing memory of 40.6mb better than 90.48% O(N)
        //An amazing example of a program where stating brute force solution got me to the ideal solution
        //Going deep into the tree and saving the maximum for every position
class Solution {
     
    int res=Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxHelper(root);
        return res;
    }
    
    public int maxHelper(TreeNode root){
        if(root==null) return 0;
        
        int left=maxHelper(root.left);
        int right=maxHelper(root.right);
        
    
        if(root.val+(left>0?left:0)+(right>0?right:0)>res){
            res=root.val+(left>0?left:0)+(right>0?right:0);
        }
        
        if(left>right){
            return (left>0?left:0)+root.val;
        }else{
            return (right>0?right:0)+root.val;
        }
    }
}