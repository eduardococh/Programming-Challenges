class Solution {
		//My solution, 30m22s
		//3ms, faster than only 22%, 40.9mb better than 96.46% (unexpected)
		//Runtime O(n), O(n) space complexity

    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> palindrome=new ArrayList<Integer>();
        while(head!=null){
            palindrome.add(head.val);
            head=head.next;
        }
        int size=palindrome.size();
        for(int i=0;i<size/2;i++){
            if(!palindrome.get(i).equals(palindrome.get(size-i-1))){
                return false;
            }
        }
        return true;
    }

	//Reverse half of list, faster than 93.59 and less memory than 96.46
	//By leetcode yavinci
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }	
	
	//Recursive solution, better time than 93.50, memory usage less than 7.75
	//Interesting but not the best solution, by rajkukadia 
    ListNode ref;
    public boolean isPalindrome(ListNode head) {
        ref = head;        
        return check(head);
    }
    
    public boolean check(ListNode node){
        if(node == null) return true;
        boolean ans = check(node.next);
        boolean isEqual = (ref.val == node.val)? true : false; 
        ref = ref.next;
        return ans && isEqual;
    }
}