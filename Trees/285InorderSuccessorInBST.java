class Solution {
    
    class SearchStatus{
        boolean status;//0 not found|found and assigned, 1 previous is q
        TreeNode result;
        
        public SearchStatus(boolean status,TreeNode result){
            this.status=status;
            this.result=result;
        }
    }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return sucessorHelper(root,p,false).result;
    }
    
    public SearchStatus sucessorHelper(TreeNode root,TreeNode p,boolean found){
        if(found==true){
            if(root==null){
                return new SearchStatus(false,root);//root could be null, meaning there's no sucessor
            }else{
                if(root.left!=null){
                    return sucessorHelper(root.left,p,true);//our leftmost children is sucessor
                }else{
                    return new SearchStatus(false,root);//we do not have children, we are sucessor
                }
            }
        }
        if(root==null) return null;
        if(root.val==p.val){
            if(root.right==null){
                return new SearchStatus(true,null); //we found q and there's no right        
            }else{
                return sucessorHelper(root.right,p,true);
            }
        }
        
        SearchStatus left=sucessorHelper(root.left,p,false);
        //if(left!=null)  System.out.println("for node "+root.val+" left is "+left.result+" "+left.status);
        if(left!=null && left.result!=null) return left;
        if(left!=null && left.status==true) return new SearchStatus(false,root);
        
        SearchStatus right=sucessorHelper(root.right,p,false);
        if(right!=null && right.result!=null) return right;
        //Its not possible for root to be sucessor of right child, only return if found
        if(right!=null && right.status==true) return new SearchStatus(true,null);
        
        return new SearchStatus(false,null);
    }
}