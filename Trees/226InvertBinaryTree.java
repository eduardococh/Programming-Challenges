		//My solution
		//Amazing runtime at 0ms better than 100% o(n) we pass by every treenode once
		//Amazing memory at 34.3mb better than 100% o(n) for worse case stack saves n 
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode auxLeft=root.left;
        TreeNode auxRight=root.right;
        root.left=auxRight;
        root.right=auxLeft;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

		//Leetcode's recursive, reduces two lines of code
public TreeNode invertTree(TreeNode root) {
    if (root == null) {
        return null;
    }
    TreeNode right = invertTree(root.right);
    TreeNode left = invertTree(root.left);
    root.left = right;
    root.right = left;
    return root;
}

		//Leetcode's iterative solution
		//Same runtime at 0ms
		//Almost same memory at 34.3mb
		//basically we invert using a temp variable and then check if left or right are not null
		//since we cant add null nodes to queue
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}