        //Good solution,
        //Run a slow and fast nodes, once they find run two slows
        //When they find you get the result
        //Amazing runtime better than 100%
        //Amazing memory better than ~90%
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