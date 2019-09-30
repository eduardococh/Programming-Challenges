        //My solution using list reversal
        //Reverse lists and then sum them using usual sum
        //Reverse the resulting list
        //Amazing runtime of 2ms better than 99.80% O(N)
        //Good memory better than ~80% O(1) (if our result list is not counted)
        //Good and simple approach, only downside is that input lists are modified
        //depending on the rules this could be approved or no
        //but we could just reverse them again at the end if it were necessary
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;
        l1=reverseList(l1);
        l2=reverseList(l2);
        ListNode dumbHead=new ListNode(0);
        ListNode pointer=dumbHead;
        int carry=0;
        while(l1!=null || l2!=null){
            int val1=l1==null?0:l1.val;
            int val2=l2==null?0:l2.val;
            pointer.next=new ListNode((val1+val2+carry)%10);
            carry=(val1+val2+carry)/10;
            pointer=pointer.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(carry!=0){
            pointer.next=new ListNode(carry);
        }
        return reverseList(dumbHead.next);
    }
    
    public ListNode reverseList(ListNode ls){
        ListNode cur=ls;
        ListNode nex=ls.next;
        cur.next=null;
        while(nex!=null){
            ListNode next=nex.next;
            nex.next=cur;
            
            cur=nex;
            nex=next;
        }
        return cur;
    }
}

        //Solution using stacks from leetcode's Hx2
        //Data structure that naturally helps inverting the lists without modifying them
        //Average runtime at 5ms better than 57.57% O(N)
        //Average memory better than 55.88% O(N)
        //Maybe not the best approach from runtime performance, but the lists are left intact
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        
        return list.val == 0 ? list.next : list;
    }
}
