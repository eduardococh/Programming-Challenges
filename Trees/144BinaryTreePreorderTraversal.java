//My solution
//Recursive, runtime O(N) better than 100%
//Memory O(N) better than 64%
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        preorderTraversal(root,result);
        return result;
    }
    
    public void preorderTraversal(TreeNode node,List<Integer> result){
        if(node==null) return;
        result.add(node.val);
        preorderTraversal(node.left,result);
        preorderTraversal(node.right,result);
    }
}