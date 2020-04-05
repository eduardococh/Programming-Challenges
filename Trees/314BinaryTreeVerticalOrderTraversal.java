        //My solution
        //Average runtime at 3ms better than 39.82% O(N)
        //Bad memory better than only 5% O(N) (Because of HashMap)
        //Simple and clear solution I think
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null) return result;
        HashMap<TreeNode,Integer> levels=new HashMap<TreeNode,Integer>();
        int min=assignLevels(root,0,levels,0);
        min=0-min;
        createResult(result,root,min,levels);
        return result;
    }
    
    public void createResult(List<List<Integer>> result, TreeNode root, int min,HashMap<TreeNode,Integer> levels){
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode next=q.poll();
            int level=levels.get(next)+min;
            while(result.size()<(level+1)){
                result.add(new ArrayList<Integer>());
            }
            result.get(level).add(next.val);
            if(next.left!=null) q.add(next.left);
            if(next.right!=null) q.add(next.right);
        }
    }
    
    public int assignLevels(TreeNode node, int level, HashMap<TreeNode,Integer> levels, int min){
        if(node==null) return min;
        levels.put(node,level);
        if(level<min) min=level;
        int left=assignLevels(node.left,level-1,levels,min);
        if(left<min) min=left;
        int right=assignLevels(node.right,level+1,levels,min);
        if(right<min) min=right;
        return min;
    }
}