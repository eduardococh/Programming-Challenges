/*
 *  My solution (2nd day) really good and elegant
 *  Surprised me given the terrible solution I came up first day
 *  Good runtime of 5ms better than 96.72% O(m*n)
 *  Amazing memory better than 100% O(N)
 *  My first take on this problem was terrible and complex and ended with a time excedeed
 *  It surprised me to see this code be so simple, not sure if an easy question as getting to this
 *  code is not easy at first?¿
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null) return false;
        if(checkCurrentNode(s,t)) return true;
        if(isSubtree(s.left,t)) return true;
        if(isSubtree(s.right,t)) return true;
        return false;
    }
    
    public boolean checkCurrentNode(TreeNode s,TreeNode t){
        if(s==null && t==null) return true;
        if(s!=null && t!=null && s.val==t.val){//current nodes are equal check childs
            if(checkCurrentNode(s.left,t.left)){
                if(checkCurrentNode(s.right,t.right)){
                    return true;
                }
            }
        }
        return false;
    }
}