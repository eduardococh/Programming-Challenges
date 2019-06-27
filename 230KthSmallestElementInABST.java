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