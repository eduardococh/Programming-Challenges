//My solution
//Runtime O(N) 
//Memory O(N)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        //0 will contain the father and 1 will contain depth
        int[] xValues=describe(root,x,-1,1);
        int[] yValues=describe(root,y,-1,1);
        if(xValues[0]!=yValues[0] && xValues[1]==yValues[1]){
            return true;
        }else{
            return false;
        }
    }
     
    public int[] describe(TreeNode root,int target,int parent,int depth){
        if(root==null) return null;
        TreeNode explore=root;
        if(root.val==target){
            return new int[]{parent,depth};
        }else{
            int[] left=describe(root.left,target,root.val,depth+1);
            if(left!=null) return left;
            int[] right=describe(root.right,target,root.val,depth+1);
            if(right!=null) return right;
            return null;
        }
    }
}