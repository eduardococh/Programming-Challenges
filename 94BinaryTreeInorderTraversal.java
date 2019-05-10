		//My solution
		//'bad' runtime at 1ms, better than only 36%
		//Good memory, better than 34%
		//Not the more elegant solution
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