		//My solution, simple and useful
		//Amazing runtime of 0ms O(N) better than 100%
		//Amazing memory of 36.3mb better than 100% O(n) (worst case when tree goes all left or right
		//filling stack with n calls)
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        int res=0;
        if(root.left!=null && root.left.right==null && root.left.left==null){
            res+=root.left.val;
        }
        res+=sumOfLeftLeaves(root.left);
        res+=sumOfLeftLeaves(root.right);
        return res;
    }
}