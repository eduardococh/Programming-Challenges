        //My solution
        //Not the best most elegant
        //Amazing runtime of 0ms better than 100% O(N)
        //Bad memory better than only 11% O(N)
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        return treeExplorer(root,1)[0];
    }
    
    public int[] treeExplorer(TreeNode root, int depth){
        int[] result=new int[]{-1,-1};
        if(root==null) return result;
        int[] left=treeExplorer(root.left,depth+1);
        int[] right=treeExplorer(root.right,depth+1);
        int leftDiameter=left[1]==-1?0:left[1]-depth;
        int rightDiameter=right[1]==-1?0:right[1]-depth;
        int myRoute=leftDiameter+rightDiameter;
        if(myRoute<left[0]) myRoute=left[0];
        if(myRoute<right[0]) myRoute=right[0];
        result[0]=myRoute;
        result[1]=left[1]>right[1]?left[1]:right[1];
        if(depth>result[1]) result[1]=depth;
        return result;
    }
}

        //DFS Solution by leetcode
        //Same approach as me but more elegant
        //Same runtime and lil better memory (better than 16%)
        //Usage of global variable to keep maximum diameter, return depth of nodes in methods
class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }
}