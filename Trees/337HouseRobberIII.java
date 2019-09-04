        //My recursive solution solution
        //"Simple" I think, but compared to other solutions complex 
        //Used something like a dynamic programming approach, where every node saves the
        //maximum value that can be done from the leaf up to it, and the maximum value if
        //we don't choose that node, we then do comparisons for every node
        //Good runtime better than 96.18 O(N)
        //Amazing memory better than 100% O(N) where we create a house status for every node
        //and also in the worse case scenario of a long branch the recursive stack would have
        //at most O(N) elements
        //Not the most elegant solution, but the usage of a custom class definetely improves
        //readability and reduces complexity, should be used more IF NECESSARY
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
        //System.out.println("my left is "+left.myBiggestValue+" witho "+left.myBiggestWithout+" was "+left.wasRobbed);
        //System.out.println("my right is "+right.myBiggestValue+" witho "+right.myBiggestWithout+" was "+right.wasRobbed);
        //NONE of my inmediate sons was robbed, rob me
        if(left.wasRobbed==false && right.wasRobbed==false){
            return new HouseStatus(true,left.myBiggestValue+right.myBiggestValue+root.val,left.myBiggestValue+right.myBiggestValue);
            
        //BOTH of my sons were robbed (they're not null)
        }else if(left.wasRobbed==true && right.wasRobbed==true){
            //Is the sum of my two sons biggest bigger than me plus two sons biggest without?
            if(left.myBiggestValue+right.myBiggestValue>root.val+right.myBiggestWithout+left.myBiggestWithout){
                return new HouseStatus(false,left.myBiggestValue+right.myBiggestValue,left.myBiggestValue+right.myBiggestValue);
            }else{
                return new HouseStatus(true,left.myBiggestWithout+right.myBiggestWithout+root.val,left.myBiggestValue+right.myBiggestValue);
            }
        //ONLY LEFT was robbed
        }else if(left.wasRobbed==true){
            //is the biggest value with left bigger than the biggest value with me and left biggest without?
            if(left.myBiggestValue>root.val+left.myBiggestWithout){
                return new HouseStatus(false,left.myBiggestValue+right.myBiggestValue,left.myBiggestValue+right.myBiggestValue);
            }else{
                return new HouseStatus(true,left.myBiggestWithout+right.myBiggestValue+root.val,left.myBiggestValue+right.myBiggestValue);
            }
        //ONLY RIGHT was robbed
        }else{
            if(right.myBiggestValue>root.val+right.myBiggestWithout){
                return new HouseStatus(false,left.myBiggestValue+right.myBiggestValue,left.myBiggestValue+right.myBiggestValue);
            }else{
                return new HouseStatus(true,left.myBiggestValue+right.myBiggestWithout+root.val,left.myBiggestValue+right.myBiggestValue);
            }
        }
    }
}


        //Resursive solution from leetcode's 0ms samples
        //It uses a simple approach, saving two values for every node
        //In the first position the sum of not using left and right plus my node value
        //In the second position the sum of the maximum between using and not using left and
        //right, which in turn will be the value of not using my node
        //So simple and elegant
        //Amazing runtime 0ms better than 100%
        //Memory better than 88% little worse than my program
        //Overall a better simpler solution
class Solution {
    public int rob(TreeNode root) {
        int[] result = recursive(root);
        return Math.max(result[0], result[1]);
    }
    
    private int[] recursive(TreeNode node) {
        int[] result = new int[2];
        if (node == null) {
            return result;
        }
        
        int[] lefts = recursive(node.left);
        int[] right = recursive(node.right);
        result[0] = lefts[1] + right[1] + node.val;
        result[1] = Math.max(lefts[0], lefts[1]) + Math.max(right[0], right[1]);
        return result;
    }
}