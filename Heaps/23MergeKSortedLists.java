        //Solution by leetcode's windliang
        //
class Solution {
    
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> cmp = new Comparator<ListNode>() {  
            @Override
            public int compare(ListNode o1, ListNode o2) {
                // TODO Auto-generated method stub
                return o1.val-o2.val;
            }
        };
 
        Queue<ListNode> q = new PriorityQueue<ListNode>(cmp);
        for(ListNode l : lists){
            if(l!=null){
                q.add(l);
            }        
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!q.isEmpty()){ 
            point.next = q.poll();
            point = point.next; 
            ListNode next = point.next;
            if(next!=null){
                q.add(next);
            }
        }
        return head.next;
        /*if(lists==null || lists.length==0) return null;
        ListNode result=new ListNode(0);
        
        Comparator<ListNode> myComp=new Comparator<ListNode>(){
            public int compare(ListNode node1,ListNode node2){
                //-1 node1 bigger, 0 equal, 1 node2 bigger
                return Integer.valueOf(node1.val).compareTo(Integer.valueOf(node2.val));
            }  
        };
        
        int cont=0;
        PriorityQueue<ListNode> pQueue = new PriorityQueue<ListNode>(myComp);
        for(int i=0;i<lists.length;i++){
            while(lists[i]!=null){
                System.out.println("we add"+lists[i].val);
                pQueue.add(lists[i]);
                lists[i]=lists[i].next;
            }
        }
        /*for(int i=0;i<lists.length;i++){
         //   pQueue
            if(lists[i]!=null){
                cont++;
                pQueue.add(lists[i]);
                lists[i]=lists[i].next;
                if(lists[i]==null) cont--;                
            }
        }
        ListNode min=pQueue.poll();
        ListNode pointer=min;
        result.next=pointer;
        int index=0;
        while(min!=null && cont>0){
            while(lists[index]==null && cont>0){
                index++;
                if(index==lists.length) index=0;
            }
            pQueue.add(lists[index]);
            lists[index]=lists[index].next;
            if(lists[index]==null) cont--;
            index++;
            if(index==lists.length) index=0;
            min=pQueue.poll();
            pointer.next=min;
            pointer=pointer.next;
        }
        ListNode pointer=pQueue.poll();
        result.next=pointer;
        while(!pQueue.isEmpty()){
            pointer.next=pQueue.poll();
            pointer=pointer.next;
            System.out.println("we remove"+pointer);
        }
        System.out.println("before going out");
        return result.next;*/
    }
}

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