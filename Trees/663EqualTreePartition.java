
class Solution {
    public boolean checkEqualTree(TreeNode root) {
        return checkEqualTreeHelper(root)[0]==1;
    }
    
    public int[] checkEqualTreeHelper(TreeNode node){
        //res at 0 contains boolean result  [0] false [1] true
        int res[]=new int[2];
        if(node==null) {
            res[0]=-1;
            return res;
        }
        res[0]=1;
        int[] left=checkEqualTreeHelper(node.left);
        if(left[0]==1){
            return res;
        }
        int[] right=checkEqualTreeHelper(node.right);
        if(right[0]==1){
            return res;
        }
        if(left[0]==-1 || right[0]==-1){
            res[0]=0;
            res[1]=left[1]+node.val+right[1];
            return res;
        }
        //none of my children has a solution
        if(node.val+left[1]==right[1]){
            return res;
        }
        if(node.val+right[1]==left[1]){
            return res;
        }
        //I am not a solution, pass me to father
        res[0]=0;
        res[1]=left[1]+node.val+right[1];
        return res;
    }
}