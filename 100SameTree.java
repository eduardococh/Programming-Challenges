		//My solution, using string builder and inorder tree traversal
		//Great runtime 0ms better than 100% O(P+Q)
		//Great memory 33.6 better than 100% O(P+Q)
		//Elegant and very clear i think	
		//tookme 10m45s

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return inorder(p,true).equals(inorder(q,true));
    }
    
    public String inorder(TreeNode root,boolean direction){
        if(root==null){
            if(direction==true){
                return "nr";
            }else{
                return "nl";   
            }
        }
        StringBuilder result=new StringBuilder("");
        result.append(inorder(root.left,false));
        result.append(root.val);
        result.append(inorder(root.right,true));
        return result.toString();
    }
}


		//Leetcode solution using recursivity
		//Great memory 33.6 and runtime 0ms
class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    // p and q are both null
    if (p == null && q == null) return true;

    // one of p and q is null
    if (q == null || p == null) return false;
    // P different than Q
    if (p.val != q.val) return false;

    return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
  }
}

		//Leetcode's iterative solution
		//Same runtime and memory as recursive
		//More challenging, should be tried
class Solution {
  public boolean check(TreeNode p, TreeNode q) {
    // p and q are null
    if (p == null && q == null) return true;
    // one of p and q is null
    if (q == null || p == null) return false;
    if (p.val != q.val) return false;
    return true;
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (!check(p, q)) return false;

    // init deques
    ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
    ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
    deqP.addLast(p);
    deqQ.addLast(q);

    while (!deqP.isEmpty()) {
      p = deqP.removeFirst();
      q = deqQ.removeFirst();

      if (!check(p, q)) return false;
      if (p != null) {
        // in Java nulls are not allowed in Deque
        if (!check(p.left, q.left)) return false;
        if (p.left != null) {
          deqP.addLast(p.left);
          deqQ.addLast(q.left);
        }
        if (!check(p.right, q.right)) return false;
        if (p.right != null) {
          deqP.addLast(p.right);
          deqQ.addLast(q.right);
        }
      }
    }
    return true;
  }
}