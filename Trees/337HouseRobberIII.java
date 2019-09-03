class Solution {
    
    private class HouseStatus{
        boolean wasRobbed;
        int myBiggestValue;
        int myBiggestWithout;
        
        public HouseStatus(boolean wasRobbed, int myBiggestValue,int myBiggestWithout){
            this.wasRobbed=wasRobbed;
            this.myBiggestValue=myBiggestValue;
            this.myBiggestWithout=myBiggestWithout;
        }
    }
    
    public int rob(TreeNode root) {
        return robHelper(root).myBiggestValue;
    }
    
    public HouseStatus robHelper(TreeNode root){
        if(root==null){
            return new HouseStatus(false,0,0);
        }
        
        HouseStatus left=robHelper(root.left);
        HouseStatus right=robHelper(root.right);
        //System.out.println("in node "+root.val);
        //System.out.println("my left is "+left.myBiggestValue+" was "+left.wasRobbed);
        //System.out.println("my right is "+right.myBiggestValue+" was "+right.wasRobbed);
        //NONE of my inmediate sons was robbed, rob me
        if(left.wasRobbed==false && right.wasRobbed==false){
            return new HouseStatus(true,left.myBiggestValue+right.myBiggestValue+root.val,left.myBiggestValue+right.myBiggestValue);
            
        //BOTH of my sons were robbed (they're not null)
        }else if(left.wasRobbed==true && right.wasRobbed==true){
            //Is the sum of my two sons bigger than me?
            if(root.left.val+root.right.val>root.val){
                return new HouseStatus(false,left.myBiggestValue+right.myBiggestValue,left.myBiggestValue+right.myBiggestValue);
            }else{
                return new HouseStatus(true,left.myBiggestWithout+right.myBiggestWithout+root.val,left.myBiggestValue+right.myBiggestValue);
            }
        //ONLY LEFT was robbed
        }else if(left.wasRobbed==true){
            //we rob left and not root
            if(root.left.val>root.val){
                return new HouseStatus(false,left.myBiggestValue+right.myBiggestValue,left.myBiggestValue+right.myBiggestValue);
            }else{
                return new HouseStatus(true,left.myBiggestWithout+right.myBiggestValue+root.val,left.myBiggestValue+right.myBiggestValue);
            }
        //ONLY RIGHT was robbed
        }else{
            //System.out.println("so we enter here "+root.val);
            if(root.right.val>root.val){
                return new HouseStatus(false,left.myBiggestValue+right.myBiggestValue,left.myBiggestValue+right.myBiggestValue);
            }else{
                return new HouseStatus(true,left.myBiggestValue+right.myBiggestWithout+root.val,left.myBiggestValue+right.myBiggestValue);
            }
        }
    }
}