class Solution {
    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result=new ListNode(0);
        
        Comparator<ListNode> myComp=new Comparator<ListNode>(){
            public int compare(ListNode node1,ListNode node2){
                //-1 node1 bigger, 0 equal, 1 node2 bigger
                return node1.val-node2.val;
            }  
        };
        
        PriorityQueue<ListNode> pQueue = new PriorityQueue<ListNode>(myComp);
        for(int i=0;i<lists.length;i++){
         //   pQueue
            pQueue.add(lists[i]);
            lists[i]=lists[i].next;
        }
        ListNode min=pQueue.poll();
        while(min!=null){
            result.next=min;
            
        }
        return result.next;
    }
}