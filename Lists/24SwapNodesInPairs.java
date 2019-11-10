        //My solution
        //It works, but too complex, not elegant
        //Using a jumper node to track pairs, doing the reversal
        //problem is that for special cases it needs a lot of conditions
        //Amazing runtime 0ms better than 100% O(N)
        //Amazing memory better than 100% O(1)
        //Not the recommended solution
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


        //Recursive solution by leetcode's whoji
        //AMAZING, SIMPLE, ELEGANT
        //Same runtime and memory as my solution (better than 100%)
        //In the discussion a lot of people noted that this problem takes O(N) memory
        //for the recursion stack
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

        //Iterative solution based on leetcode's tusizi solution
        //This code is clearer in my opinion
        //Preferred over recursive by some due to constant space
        //Still simple and better than my approach
        //First and second are pretty obvious, current is the one that's tricky
        //to understand, is will always be behind first and second, and the references
        //that it has are not final
        //Runtime better than 100% O(N)
        //Memory better than 100% O(1)
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode current=dummy;
        while(current.next!=null && current.next.next!=null){
            ListNode first=current.next;
            ListNode second=current.next.next;
            first.next=second.next;
            second.next=first;
            current.next=second;
            current=current.next.next;
        }
        return dummy.next;
    }
}