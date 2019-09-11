        //My solution
        //Found this problem in a MS mock interview and weren't able to do it
        //in 1 hour, but it turned out to be very simple
        //Good runtime 1ms better than 92.41%
        //Amazing memory better than 100%
        //Counts the number of coins that are missing or are left over
        //this is for every node, the just sums it ()
class Solution {
    
    public int distributeCoins(TreeNode root) {
        return distributeCoinsHelper(root,0)[1];
    }
    
    public int[] distributeCoinsHelper(TreeNode root,int result) {
        //My return will have the node val in 0 and result in 1
        if(root==null) return new int[]{0,result};
        int left[]=distributeCoinsHelper(root.left,result);
        result=left[1];
        int right[]=distributeCoinsHelper(root.right,result);
        result=right[1];
        //System.out.println("result "+result);
        //System.out.println("node "+root.val+" has "+left[0]+right[0]+(root.val-1));
        result+=Math.abs(left[0]+right[0]+(root.val-1));
        return new int[]{left[0]+right[0]+(root.val-1),result};
    }
    
}


        //Leetcode's DFS solution
        //Same memory and runtime as my approach
        //Simpler, more elegant code
        //Same approach as me, sum the value of 
        //here they use a global ans variable instead of 
        //the array that I used, depending on who you ask this is a better approach 
        //than not using a global variable
class Solution {
    int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        ans += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;
    }
}