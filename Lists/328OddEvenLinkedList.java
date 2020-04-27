		//My solution, not the most elegant
		//runtime of 0ms better than 100% O(N)
		//memory of 37.2mb, better than 40% only
		//My approach and leetcode's was the same, implementation differed
		//Cont and complex next.next were not necesary, cont must have been the extra memory
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return null;
        
        ListNode oddPointer=head;
        ListNode evenBase=head.next,evenPointer=head.next;
        int cont=1;
        
        while(oddPointer!=null && evenPointer!=null){
            
            //System.out.println("odd "+oddPointer.val);
            if(cont%2==1){//Odd
                if(oddPointer.next!=null){
                    oddPointer.next=oddPointer.next.next;    
                }
                if(oddPointer.next!=null){
                    oddPointer=oddPointer.next;   
                }else{
                    break;
                }
            }else{//Even
                if(evenPointer.next!=null){
                    evenPointer.next=evenPointer.next.next;
                }
                evenPointer=evenPointer.next;
            }
            cont++;
            
        }
        oddPointer.next=evenBase;
        return head;
    }
}

			//Leetcode's solution, ELEGANT READABLE
			//Runtime of 0ms better than 100% O(N)
			//Memory of 37mb, better than 92.72% O(1)
			
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}