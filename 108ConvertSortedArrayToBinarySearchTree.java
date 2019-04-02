
class Solution {
		//My recursive solution, 38.3mb better than only 7%, 2ms
    public TreeNode sortedArrayToBST(int[] nums) {
        int middle=nums.length,levelSize=1;
        TreeNode result=null;
        return partitioner(result,nums);
    }
    
    private TreeNode partitioner(TreeNode result,int[] nums){
        /*for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]);
        }
        System.out.println("/n");*/
        if(nums.length==0){
            //System.out.println("agrego nulo");
            return null;
        }else if(nums.length==1){
            result=addToTree(nums[0],result);
            //System.out.println("agrego uno "+nums[0]);
        }else{
            int middle=nums.length/2;      
            //System.out.println("agrego mas "+nums[middle]);
            result=addToTree(nums[middle],result);
            TreeNode leftTree=prtitioner(result,Arrays.copyOfRange(nums,0, middle));
            if(leftTree!=null){
                result=leftTree;
            }
            TreeNode rightTree=partitioner(result,Arrays.copyOfRange(nums,middle+1,nums.length));
            if(rightTree!=null){
                result=rightTree;
            }
        }
        return result;
    }
    
    private TreeNode addToTree(int number,TreeNode result){
        if(result==null){
            return new TreeNode(number);
        }else{
            if(number<result.val){
                if(result.left==null){
                    result.left=new TreeNode(number);
                }else{
                    result.left=addToTree(number,result.left);
                }
            }else{
                if(result.right==null){
                    result.right=new TreeNode(number);
                }else{
                    result.right=addToTree(number,result.right);
                }
            }
        }
        return result;
    }
}