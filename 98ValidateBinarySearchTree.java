/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.StringTokenizer;

class Solution {
	//FIRST UGLY SOLUTION
    public boolean isValidBST(TreeNode root) {
        String list=inorder(root,"");
        if(list!=null){
            StringTokenizer st=new StringTokenizer(list,",");
            int previous=Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int current=Integer.parseInt(st.nextToken());
                if(previous>=current){
                    return false;
                }
                previous=current;
            }
            return true;
        }else{
            return true;   
        }
    }
    
    public String inorder(TreeNode root,String inorderr){
        if(root==null){
            return null;
        }else{
            if(root.left!=null){
                inorderr=inorder(root.left,inorderr);
            }
            inorderr=inorderr+","+root.val;
            
            if(root.right!=null){
                inorderr=inorder(root.right,inorderr);
            }
            return inorderr;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if(root!=null){
            return inorder(root,new int[]{Integer.MIN_VALUE},false);
        }else{
            return true;   
        }
    }
    //SECOND UGLY SOLUTION (USING INT AND FLAGS), FASTER OF THE THREE
    public boolean inorder(TreeNode root,int[] previous,boolean first){
        boolean result=true;
        if(root.left!=null){
            if(first==false){
                result=inorder(root.left,previous,false);
                first=true;
            }else{
                result=inorder(root.left,previous,true);
            }
            if(result==false){return false;}
        }
        if(root.val<=previous[0] && first==true){
            return false;
        }else{
            previous[0]=root.val;
        }
        if(root.right!=null){
            result=inorder(root.right,previous,true);
        }
        return result; 
    }

    //CLEANER BUT SLOWER
public boolean isValidBST(TreeNode root) {
        if(root!=null){
            return inorder(root,new Long[]{Long.MIN_VALUE});
        }else{
            return true;   
        }
    }
    
    public boolean inorder(TreeNode root,Long[] previous){
        boolean result=true;
        if(root.left!=null){
            result=inorder(root.left,previous);
            if(result==false){return false;}
        }
        
        if(root.val<=previous[0]){
            return false;
        }else{
            previous[0]=(long)root.val;
        }
        
        if(root.right!=null){
            result=inorder(root.right,previous);
        }
        return result; 
    }

	//shorter code
    public boolean isValidBST(TreeNode root) {
       
        
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    
    }
    
    
    private boolean validBST(TreeNode root, long min, long max){
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return validBST(root.left, min, root.val) && validBST(root.right, root.val, max);
        
        
    }
}
