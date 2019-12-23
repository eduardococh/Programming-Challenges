        //My recursive solution
        //Terrible runtime of 2ms
        //Terrible memory 38.3mb better than only 7%
class Solution {
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
        }else{
            int middle=nums.length/2;      
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


        //My second approach
        //WAY better than first time
        //Big improvement is to use index instead of creating a new array
        //for every recursion
        //Amazing runtime of 0ms better than 100% O(N)
        //Amazing memory better than 60.83% O(Log N)
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0) return null;
        return bstCreator(nums,0,nums.length-1);
    }
    
    public TreeNode bstCreator(int[] nums, int low, int high){
        if(low>high) return null;
        int mid=(low+high)/2;
        TreeNode res=new TreeNode(nums[mid]);
        res.left=bstCreator(nums,low,mid-1);
        res.right=bstCreator(nums,mid+1,high);
        return res;
    }
}