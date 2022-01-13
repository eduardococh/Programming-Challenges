//My solution using dfs and array for object sum
//Runtime O(N) 0ms better than 100%
//Memory O(N) 39mb better than 60%
//Good and simple solution
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        int totalSum[]=new int[1];
        dfs(root,0,totalSum);
        return totalSum[0];
    }
    
    public void dfs(TreeNode node,int valueSoFar,int[] totalSum){
        if(node==null) return;
        valueSoFar=(valueSoFar+node.val);
        dfs(node.left,valueSoFar*2,totalSum);
        dfs(node.right,valueSoFar*2,totalSum);
        if(node.left==null && node.right==null){
            totalSum[0]+=valueSoFar;
        }
    }
}

