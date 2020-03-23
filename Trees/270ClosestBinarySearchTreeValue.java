/*
    My solution using binary search
    If current node is bigger than target go left, else go right
    In every node check the difference in double value and update closest
    Do this until reaching bottom of tree
    Amazing runtime of 0ms better than 100% O(H) where H is the height of the tree
    Bad memory better than only 5% O(1)
*/
class Solution {
    public int closestValue(TreeNode root, double target) {
        TreeNode node=root;
        int closest=root.val;
        double closestDistance=Math.abs(root.val-target);
        while(node!=null){
            double currentDistance=Math.abs(node.val-target);
            if(currentDistance<closestDistance){
                closest=node.val;
                closestDistance=currentDistance;
            }
            if(node.val>target){
                node=node.left;
            }else{
                node=node.right;
            }
        }
        return closest;
    }
}