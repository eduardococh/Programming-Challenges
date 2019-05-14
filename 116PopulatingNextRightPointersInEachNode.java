		//My solution, the hardest was figuring out the input format
		//Amazing runtime better than 100% o(n) where n is total number of nodes
		//Great memory 33.4mb better than 97.83% o(1) bc we dont need extra space
		//
class Solution {
    public Node connect(Node root) {
        if(root!=null){
            if(root.left!=null){
                root.left.next=root.right;
                if(root.next!=null){
                    root.right.next=root.next.left;
                }
                connect(root.left);
                connect(root.right);
            }
        }
        return root;
    }
}


		//Leetcode's UpTheHell iterative solution with small change
		//Same runtime 0ms
		//Better memory at 33.3mb better than 97.83% (leetcode its weird with this)
		//Better than recursive approach since you avoid usage of stack, which is faster
		//and uses less memory
		//Linking level by level this node two sons with next left son if exists, and keeping
		//a pointer to the start of next level so we can start another iteration
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        TreeLinkNode cur = root;
        TreeLinkNode nextLeftmost = null;

        while(cur.left!=null){
            nextLeftmost = cur.left; // save the start of next level
            while(cur!=null){

                cur.left.next=cur.right;
		if(cur.next==null){
		    cur.right.next = null;
		}else{
		    cur.right.next = cur.next.left;
		}

                cur=cur.next;
            }
            cur=nextLeftmost;  // point to next level 
        }
    }
}