/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        if(root.left!=null && root.right!=null){//none is null
            System.out.println("node "+root.left.val+" has next "+root.right.val);
            root.left.next=root.right;
        }
        //i have next node
        if(root.next!=null){
            if(root.right!=null){
                assignNext(root,true);
            }else if(root.left!=null){
                assignNext(root,false);
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
    
    public void assignNext(Node root,boolean next){
        if(next){
            if(root.next.left!=null){
                root.right.next=root.next.left;
            }else if(root.next.right!=null){
                root.right.next=root.next.right;
            }//else 
        }else{
            if(root.next.left!=null){
                root.left.next=root.next.left;
            }else if(root.next.right!=null){
                root.left.next=root.next.right;
            }//else 
        }
    }
}