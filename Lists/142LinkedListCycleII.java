
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode walker=head,runner=head;
        do{
            if(runner==null)return null;
            runner=runner.next;
            if(runner==null) return null;
            runner=runner.next;
            walker=walker.next;
        }while(walker!=runner);
        ListNode walker2=head;
        while(!walker.equals(walker2)){
            walker=walker.next;
            walker2=walker2.next;
        }
        return walker;
    }
}