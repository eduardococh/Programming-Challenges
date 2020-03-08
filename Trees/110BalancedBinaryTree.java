		//My solution, took me long and it's complex
		//Acceptable runtime of 1ms better than 82%
		//Amazing memory better than 99.32%
		//Usage of two recursive functions, not the best
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return verifyTree(root);
    }
    
    public boolean verifyTree(TreeNode root){
        if(root==null){
            return true;
        }
        if(verifyTree(root.left)==false || verifyTree(root.right)==false){
            return false;
        }
        int left=treeCount(root.left,0);
        if(left==-1){
            return false;
        }
        int right=treeCount(root.right,0);
        if(right==-1){
            return false;   
        }
        return left-right==-1 || left-right==0 || left-right==1;
    }
    
    public int treeCount(TreeNode root,int depth){
        if(root==null){
            return depth;
        }
        depth++;
        return Math.max(treeCount(root.left,depth),treeCount(root.right,depth));
    }
}

		//Simpler approach by leetcode's mingyuan
		//Usage of only one recursion, similar to my approach
		//But easier and more elegant
		//Great runtime 0ms better than 100%
		//Good memort better than 79% (worse than my approach, dont know why
		//but to me this seems better with memory)
public boolean isBalanced(TreeNode root) {
    if(root==null){
        return true;
    }
    return height(root)!=-1;
    
}
public int height(TreeNode node){
    if(node==null){
        return 0;
    }
    int lH=height(node.left);
    if(lH==-1){
        return -1;
    }
    int rH=height(node.right);
    if(rH==-1){
        return -1;
    }
    if(lH-rH<-1 || lH-rH>1){
        return -1;
    }
    return Math.max(lH,rH)+1;
}

		//Another interesting solution by leetcode's Nkeys
		//Worse than approach above because if left is not balanced it checks right
		//which wastes time
public boolean isBalanced(TreeNode root) {
        return depth(root)!=-1 ;
}

public int depth(TreeNode root){
    
    if(root==null)
        return 0;
        
    int ld = depth(root.left);
    int rd = depth(root.right);
    
    
    if (ld==-1 || rd==-1 || rd-ld>1 || ld-rd>1)
        return -1;
    else    
        return ( ld>=rd ? ld+1 : rd+1 ) ;    

}
