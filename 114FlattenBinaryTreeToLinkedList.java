		//My solution
		//Average runtime of 1ms better than 45% O(N*N)¿? (where n is the number of nodes)
		//the extra n is because of the while operation to search for the tip¿?
		//Average memory better than 57.04%
		//Big flaw of my solution is my search for rightmost, which decreases performance
		//and potentially adds anoter ¿*n? to time complexity
class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        if(root.left!=null && root.right!=null){
            TreeNode auxL=root.left;
            TreeNode auxR=root.right;
            root.left=auxR;
            root.right=auxL;
            flatten(root.left);
            flatten(root.right);
            TreeNode rightmost=root;
            while(rightmost.right!=null){
                rightmost=rightmost.right;
            }
            rightmost.right=root.left;
            root.left=null;
        }else if(root.right==null){
            root.right=root.left;
            flatten(root.right);
            root.left=null;
        }else{
            flatten(root.right);
        }
    }
}


		//Solution from leetcode's 0ms sample
		//Should run in 0ms but when I ran it took 1ms
		//I'll suppose 0ms runtime better than 100% O(n)
		//Memory better than 57.04%
		//Big improvement is not searching for rightmost by returning leftmost in every case
		//this is brilliant, basically go and flatten my left, get the rightmost of the flattened
		//left and their new right is root.right, root.right is now root.left and null left
		//Also it reduces ifs because
		//where i used one extra if for (root==null) and another for (l/r!=null),
		//here is done more elegantly (with no need of an if)
class Solution {
    public void flatten(TreeNode root) {
        if (root != null) {
            flattenHelper(root);
        }
    }
    
    private TreeNode flattenHelper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left == null) {
            return flattenHelper(root.right);
        }
        if (root.right == null) {
            root.right = root.left;
            root.left = null;
            return flattenHelper(root.right);
        }
        TreeNode tail = flattenHelper(root.left);
        tail.right = root.right;
        root.right = root.left;
        root.left = null;
        return flattenHelper(tail.right);
    }
}