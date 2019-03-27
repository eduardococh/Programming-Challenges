class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer=head;
        HashMap<Integer,ListNode> myMap=new HashMap<Integer,ListNode>();
        int cont=0;
        while(pointer!=null){
            myMap.put(cont,pointer);
            pointer=pointer.next;
            cont++;
        }
        if(myMap.get(cont-n-1)!=null){
            myMap.get(cont-n-1).next=myMap.get(cont-n).next;   
        }else{
            return head.next;
        }
        return head;
    }
    //Solution from leetcode one pass
    public ListNode removeNthFromEnd(ListNode head, int n) {
    
    ListNode start = new ListNode(0);
    ListNode slow = start, fast = start;
    slow.next = head;
    
    //Move fast in front so that the gap between slow and fast becomes n
    for(int i=1; i<=n+1; i++)   {
        fast = fast.next;
    }
    //Move fast to the end, maintaining the gap
    while(fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    //Skip the desired node
    slow.next = slow.next.next;
    return start.next;
}
}