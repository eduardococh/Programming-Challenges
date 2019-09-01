        //My solution
        //Good runtime better than 93.71% O(N)
        //Good solution, simple and clear, memory is on the bad side thou
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