		//leetcodes recursive solution
		//Average runtime at 1ms better than 57.25% o(N)
		//Good memory better than 88.04% o(n)
		//It just does an inorder traversal of the tree and stores it in an array list
		//then return K-1

class Solution {
  public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
    if (root == null) return arr;
    inorder(root.left, arr);
    arr.add(root.val);
    inorder(root.right, arr);
    return arr;
  }

  public int kthSmallest(TreeNode root, int k) {
    ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
    return nums.get(k - 1);
  }
}


		//My recursive solution
		//Bad runtime at 3ms better than 10.61% o(n)
		//Bad memory better than 28.65%
		//Just more complex than leetcode's approach, not worth it
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> sb=new ArrayList();
        sb=generateSB(root,sb);
        return sb.get(k-1);
    }
    
    private ArrayList<Integer> generateSB(TreeNode root,ArrayList sb){
        if(root==null){
            return sb;
        }
        if(root.left!=null){
            sb.addAll(generateSB(root.left,new ArrayList<Integer>()));
        }
        sb.add(root.val);
        if(root.right!=null){
            sb.addAll(generateSB(root.right,new ArrayList<Integer>()));
        }
        return sb;
    }
}



		//leetcode's iterative approach using a stack
		//Amazing runtime at 0ms better than 100% o(n)
		//Amazing memory better than 99.98% o(n)
		//To my surprise this was the best algorithm, and it is because there's no need
		//to save the inorder in an array list, you just go through the tree and stop when k is equal to 0
		//that's what i wanted to do but couldn't, the trick is using a stack and adding all visited nodes
		//to stack, this way your stack keeps track of the inorder and you can keep going through the array
		//going over my issue with the "get to min" problem
class Solution {
  public int kthSmallest(TreeNode root, int k) {
    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

    while (true) {
      while (root != null) {
        stack.add(root);
        root = root.left;
      }
      root = stack.removeLast();
      if (--k == 0) return root.val;
      root = root.right;
    }
  }
}


		//My complex iterative solution (my recursive solution with same approach
		//was equally bad)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        boolean left=false;
        if(root==null) return 0;
        Stack<TreeNode> st=new Stack();
        if(root.left==null){
            st.push(root);
        }
        while(root.left!=null){
            left=true;
            st.push(root);
            TreeNode father=root;
            root=root.left;
            father.left=null;
        }
        k--;
        TreeNode current=root;
        while(k>0 && !st.isEmpty()){
            //System.out.println("we addd");
            current=st.pop();
            k--;
            if(current.left!=null){
                left=true;
                st.push(current.left);
            }
            if(current.right!=null){
                st.push(current.right);
            }
        }
        if(!left){
            current=st.pop();
        }
        return current.val;
    }
}