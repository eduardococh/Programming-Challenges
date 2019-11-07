        //My solution
        //It works, but too complex, not elegant
        //
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        //at least two nodes
        ListNode dummy=new ListNode(0);
        dummy=head.next;
        ListNode jumper=head;
        ListNode A=null;
        ListNode B;
        while(jumper!=null && jumper.next!=null){
            A=jumper;
            B=jumper.next;
            jumper=jumper.next.next;
            B.next=A;
            if(jumper!=null){
                A.next=jumper.next;   
            }else{
                A.next=null;
            }
        }
        if(jumper!=null && jumper.next==null){
            A.next=jumper;
        }
        return dummy;
    }
}


class Solution {
    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}


public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode current = dummy;
    while (current.next != null && current.next.next != null) {
        ListNode first = current.next;
        ListNode second = current.next.next;
        first.next = second.next;
        current.next = second;
        current.next.next = first;
        current = current.next.next;
    }
    return dummy.next;
}