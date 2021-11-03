//My recursive Solution
//Runtime O(N) 0 MS better than 100%
//Memory O(N) better than 96.49%
//Pretty simple, recursive doesn't feel like a medium, iterative solution is harder and good to do next time
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);
    }
    
    public int sumNumbers(TreeNode node,int parentVal){
        if(node==null) return 0;
        int numberSoFar=(parentVal*10)+node.val;
        if(node.left==null && node.right==null){
            return numberSoFar;
        }else{
            int leftNumber=sumNumbers(node.left,numberSoFar);
            int rightNumber=sumNumbers(node.right,numberSoFar);
            return leftNumber+rightNumber;
        }
    }
}