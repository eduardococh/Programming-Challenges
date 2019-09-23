class Solution {
	//My solution, large but pretty good 1ms better than 93.92% and less memory than 97.90
	//Runtime o(n) only one pass to both lists, memory o(1) since we only create 1 pointer and result
   //took me 10.32 min
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode result;
        if(l1.val<l2.val){
            result=new ListNode(l1.val);
            l1=l1.next;
        }else{
            result=new ListNode(l2.val);
            l2=l2.next;
        }
        ListNode pointer=result;
        while(l1!=null || l2!=null){
            if(l1==null){
                pointer.next=new ListNode(l2.val);
                l2=l2.next;
                pointer=pointer.next;
            }else if(l2==null){
                pointer.next=new ListNode(l1.val);
                l1=l1.next;
                pointer=pointer.next;
            }else if(l1.val<l2.val){
                pointer.next=new ListNode(l1.val);
                l1=l1.next;
                pointer=pointer.next;
            }else{
                pointer.next=new ListNode(l2.val);
                l2=l2.next;
                pointer=pointer.next;
            }
        }
        return result;
    }

		//More elegant solution, recursive by leetcode sample 0ms
		//o(n) runtime
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val)
        {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else
        {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}