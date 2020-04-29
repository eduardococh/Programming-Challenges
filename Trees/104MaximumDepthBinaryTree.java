        //My DFS Solution
        //Amazing runtime 0ms better than 100% O(N)
class Solution {
    public int maxDepth(TreeNode root) {
        int max=1,current=1;
        if(root!=null){
            return exploreTree(root,current,max);   
        }else{
            return 0;
        }
    }
    
    public int exploreTree(TreeNode node,int current,int max){
        if(current>max){
            max=current;
        }
        current++;
        if(node.left!=null){
            max=exploreTree(node.left,current,max);
        }
        if(node.right!=null){
            max=exploreTree(node.right,current,max);
        }
        return max;
    }

    //Simple
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}