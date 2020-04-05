        //My solution using three variables
        //These are the minimum number of variables, you can't do it with two since you need to keep linking
        //Amazing runtime 0ms better than 100% O(N)
        //Bad memory better than 5% O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode current=head;
        ListNode next=head.next;
        current.next=null;
        while(next!=null){
            ListNode n1=next.next;
            next.next=current;
            current=next;
            next=n1;
        }
        return current;
    }
}

        //Leetcode's solution
        //More elegant than mine
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
}