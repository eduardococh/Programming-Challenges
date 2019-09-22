        //My recursive solution
        //Based on leetcode's solution
        //Good runtime of 1ms faster than 73.88%
        //Amazing memory of 99.07%
        
class Solution {
    
    HashMap<Node,Node> visitedNodes=new HashMap<Node,Node>();
    
    public Node copyRandomList(Node head) {
        
        if(head==null){
            return null;
        }
        
        if(this.visitedNodes.containsKey(head)){
            return this.visitedNodes.get(head);
        }
        
        Node newNode=new Node();
        newNode.val=head.val;
        
        this.visitedNodes.put(head,newNode);
        
        newNode.next=this.copyRandomList(head.next);
        newNode.random=this.copyRandomList(head.random);
        
        return newNode;
    }
}