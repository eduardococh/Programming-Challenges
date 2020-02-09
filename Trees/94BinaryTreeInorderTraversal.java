		//My solution
		//'bad' runtime at 1ms, better than only 36%
		//Good memory, better than 34%
		//Not the most elegant solution
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root!=null){
            stack.push(root);
        }else{
            return result;
        }
        while(stack.isEmpty()==false){
            TreeNode current=stack.pop();
            if(current.left==null && current.right==null){
                result.add(current.val);    
            }else{
                if(current.right!=null){
                    stack.push(current.right);
                    current.right=null;
                }
                TreeNode left=null;
                if(current.left!=null){
                    left=current.left;
                    current.left=null;
                }
                stack.push(current);
                if(left!=null){
                    stack.push(left);
                }   
            }
        }
        return result;
    }
}

		//Leetcode's recursive solution, like they said 'trivial'
		//Runtime of o(N)
		//Space complexity of o(n) in worse case, average case o(log(n))
		//Easy solution, goto

class Solution {
    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}

		//leetcode's iteration using stack
		//My approach, but more elegantly programmed
		//Time and space complexity of o(n) 
		//Basically recursivelly add all lefts until null, then for every
		//added node to the stack add its value and their right 

public class Solution {

    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

}

		//Leetcode's morris traversal
		//Seems  hard at the beggining but its simple actually
		//Use of a threaded binary tree	
		//When ANY node has a LEFT CHILD, it searches for the RIGHTMOST node 
		//in their left subtree, when theres no left child it adds their value and goes to right child if theres any
		//we end up with a tree which is a line of just right childs

		//So for example given leetcodes tree    1,2,3
		//The first step would give 2,1,3 and this would give the inorder traversal
		//or given 1,2,3,4,5,6,null it would be after 1 iteration 2,4,5,null,null,null,1,null,3,6,null
		//in iteration 2 it would become 4,null,2,null,5,null,1,null,3,6,null
		//in iteration 3 it would become 4,null,2,null,5,null,1,null,6,null,3
		//in the end it will give inorder 4,2,5,1,6,3
 
class Solution {

    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        TreeNode curr = root;
        TreeNode pre;

        while (curr != null) {

            if (curr.left == null) {//Does not have a left subtree

                res.add(curr.val);
                curr = curr.right; // move to next right node

            } else { // has a left subtree

                pre = curr.left;

                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }

                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }
}