//My solution, simple DFS
//For every node calculate tilt, add to general sum, and return left+right+myself
//Runtime O(N)
//Memory O(N)
class Solution {
    public int findTilt(TreeNode root) {
        int [] generalSum=new int[1];
        findTilt(root,generalSum);
        return generalSum[0];
    }
    
    public int findTilt(TreeNode node,int[] generalSum){
        if(node==null) return 0;
        int left=findTilt(node.left,generalSum);
        int right=findTilt(node.right,generalSum);
        generalSum[0]+=Math.abs(left-right);
        return left+right+node.val;
    }
}