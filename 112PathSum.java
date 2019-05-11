		//My recursive solution
		//Great runtime better than 100%
		//Good memory better than 90.9%
		//just easy problem

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        return isSum(root,sum,0);
    }
    
    public boolean isSum(TreeNode root,int sum, int current){
        if(root==null){
            return false;
        }
        current=current+root.val;
        if(current==sum && root.left==null && root.right==null){
            return true;
        }else{
            if(isSum(root.right,sum,current)==true){
                return true;
            }
            if(isSum(root.left,sum,current)==true){
                return true;
            }
        }
        return false;
    }
}

			//More elegant solution
			//Same runtime and better memory
			//Good
public boolean hasPathSum(TreeNode root, int sum) {

      if(root == null){ 
          return false;
      }

      sum = sum-root.val;
      if(sum == 0 && root.left == null && root.right == null) { 
          return true;
      }

      return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
}