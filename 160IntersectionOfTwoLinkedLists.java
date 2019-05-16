		//My solution, using a hashset
		//Bad runtime at 8ms, better than only 16%
		//Bad memory better than only 47.09%
		//not very good
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> mySet=new HashSet<ListNode>();
        if(headA==null || headB==null){
            return null;
        }
        while(headA!=null){
            mySet.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(mySet.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }
}


		//Two pointers approach
		//Good runtime at 2ms, but only better than 25%
		//Great memory better than 93.88%
		//Very simple and elegant approach, better implementations exist
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode aRunner=headA,bRunner=headB;
        ListNode endA=null,endB=null;
        while(!aRunner.equals(bRunner)){
            if(aRunner.next==null){
                endA=aRunner;
                aRunner=headB;
            }else{
                aRunner=aRunner.next;   
            }
            if(bRunner.next==null){
                endB=bRunner;
                bRunner=headA;
            }else{
                bRunner=bRunner.next;   
            }
            if(endA!=null && endB!=null && !endA.equals(endB)){
                return null;
            }
        }
        return aRunner;
    }
}

		//Faster approach from leetcode 0ms samples
		//0ms runtime, better than 100%
		//SAme as my approach, but here you get to the end of both lists, then get the 
		//difference in lenght and based on that get the head of the longest list to the same level
		//of the other list
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode resA = headA;
        ListNode resB = headB;
        int countA = 0;
        while(resA != null) {
            resA = resA.next;
            countA ++;
        }
        
        int countB = 0;
        while(resB != null) {
            resB = resB.next;
            countB ++;
        }
        
        int diff = Math.abs(countA - countB);
        if(countA > countB) {
            while(diff > 0) {
                headA = headA.next;
                diff --;
            }
        }
        else if(countA < countB) {
            while(diff > 0) {
                headB = headB.next;
                diff --;
            }
        }
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
