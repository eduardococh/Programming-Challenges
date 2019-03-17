/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=null,current=null,next=null;
        int value=(l1.val+l2.val)%10;
        result=new ListNode(value);
        int ten=(l1.val+l2.val)/10;
        current=result;
        while(l1.next!=null || l2.next!=null){
            if(l1.next==null && l2.next==null){
                break;
            }else if(l1.next==null){
                l1.next=new ListNode(0);
            }else if(l2.next==null){
                l2.next=new ListNode(0);
            }
            l1=l1.next;
            l2=l2.next;
            value=(l1.val+l2.val+ten)%10;
            next=new ListNode(value);
            current.next=next;
            current=current.next;
            ten=(l1.val+l2.val+ten)/10;
        }
        if(ten!=0){
            current.next=new ListNode(ten);
        }
        return result;
    }
}