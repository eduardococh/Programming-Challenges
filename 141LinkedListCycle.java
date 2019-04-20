public class Solution {
		//My solution with two pointers, best solution, runtime if it has no cycle o(n)
		//runtime if it has cycle the worst case time complexity is O(N+K), which is O(n).
		//Memory o(n)
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode slow=head,fast=head;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
            }else{
                return false;
            }
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}

//Hash table approach, worse time and memory but just to keep it in mind
public boolean hasCycle(ListNode head) {
    Set<ListNode> nodesSeen = new HashSet<>();
    while (head != null) {
        if (nodesSeen.contains(head)) {
            return true;
        } else {
            nodesSeen.add(head);
        }
        head = head.next;
    }
    return false;
}