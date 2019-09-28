        //My recursive solution
        //Usage of 4 variables to do the reversal, then recursively craft it
        //Usage of a cont to keep track of k groups
        //Amazing runtime at 0ms better than 100% O(N)
        //Good memory better than 92% O(N/k)
        //Good enough for recommending it
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseKGroupH(head,k-1);
    }
    
    public ListNode reverseKGroupH(ListNode head, int k) {
        int cont=0;
        ListNode front=head;
        ListNode back=head;
        ListNode p2=head!=null?head.next:null;
        ListNode dummy=null;
        
        while(front!=null){
            cont++;
            front=front.next;
        }
        if(cont<k+1) return head;
        cont=0;
        front=head;
        
        while(p2!=null && cont<k){
            dummy=p2.next;
            p2.next=back;
            front.next=dummy;
            back=p2;
            p2=front.next;
            cont++;
        }
        //Base case, dummy is null, stop recursion
        if(dummy!=null)front.next=reverseKGroupH(dummy,k);
        return back;
    }
}