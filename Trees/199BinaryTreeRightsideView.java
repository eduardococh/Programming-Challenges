        //My solution using DFS
        //Amazing runtime better 0ms better than 100% O(N)
        //Bad memory better than only 5.88% O(N)
        //after exploring forum and samples I found this is the best approach
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        exploreTree(root,result,0);
        return result;
    }
    
    public void exploreTree(TreeNode node,List<Integer> result,int level){
        if(node==null) return;
        if(level>=result.size()) result.add(node.val);
        exploreTree(node.right,result,level+1);
        exploreTree(node.left,result,level+1);
    }
}

        //Leetcode offers complicated solutions not worth visiting