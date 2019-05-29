		//My solution
		//Amazing runtime at 1ms better than 99.38%
		//faster solution at 0ms is too long so not worth it
		//Amazing memory better than 99.42%

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode prevHead=dummyHead;
        while(head!=null){
            if(head.val==val){
                prevHead.next=head.next;
            }else{
                prevHead=prevHead.next;
            }
            head=head.next;
        }
        return dummyHead.next;
    }
}