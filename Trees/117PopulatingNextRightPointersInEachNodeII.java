        //From leetcode's 0ms solution
        //Amazing runtime 0ms better than 100% O(N)
        //Amazing memory better than 92.86% O(1) (problem specifies stack does not count)
        //the trick is using temp as the start of every level and curr and root as iterators
class Solution {
    public Node connect(Node root) {
    
        if(root==null )
            return root;
        
        Node ans =root;
            
        Node temp = new Node(0);
        
        Node cur =temp;
        while(root!=null){

            while(root!=null){

                if(root.left!=null){
                    cur.next = root.left;
                    cur=cur.next;
                }
                if(root.right!=null){
                    cur.next = root.right;
                    cur = cur.next;
                }
                root=root.next;

            }
            root=temp.next;
            cur=temp;
            cur.next=null;
        }
        return ans;
    }
}