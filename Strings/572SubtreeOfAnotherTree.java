

/*
     3
    / \
   4   5
  / \
 1   2
 
   4 
  / \
 1   2
*/

/*
c=3


*/
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null && t==null) return true;
        if(s==null || t==null) return false;
        if(s.val==t.val){//valid
            boolean valid=true;
            valid=isSubtree(s.left,t.left);
            if(valid){
                valid=isSubtree(s.right,t.right);    
                if(valid) return true;
            }
        }
        if(isSubtree(s.left,t)){
            return true;
        }
        if(isSubtree(s.right,t)){
            return true;
        }
        return false;
    }
}