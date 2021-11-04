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


//Second solution, got this problem on daily leetcode challenges
//Same approach as above, I believe more elegant
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root,false);
    }
    
    public int sumOfLeftLeaves(TreeNode node,boolean left){
        if(node==null) return 0;
        if(left && node.left==null && node.right==null) return node.val;
        return sumOfLeftLeaves(node.left,true)+sumOfLeftLeaves(node.right,false);
    }
}