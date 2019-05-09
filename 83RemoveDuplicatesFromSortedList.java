		//My solution, O(N) runtime better than only 33.64%
		//and o(1) memory better than 98.68%
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode result=head,preHead=head;
        int max=head.val;
        head=head.next;
        while(head!=null){
            if(head.val>max){
                max=head.val;
                preHead=preHead.next;
            }else{
                if(head.next!=null){
                    preHead.next=head.next;
                }else{
                    preHead.next=null;
                }
            }
            head=head.next;
        }
        return result;
    }
}


		//Leetcodes solution, MORE ELEGANT AND READABLE CODE
		//Exactly same runtime and memory
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}

		//Leetcode sample 0ms solution, better runtime than 100%
		//Better memory than 98.64%
		//This approach don't use next.next, other than that i dont know where is it better
		//Than leetcode's approach
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode prev = dummyHead;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                prev.next = head.next;
                head = head.next;
            } else {
                prev = head;
                head = head.next;
            }
         }
        return dummyHead.next;
    }
}