class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer=head;
        HashMap<Integer,ListNode> myMap=new HashMap<Integer,ListNode>();
        int cont=0;
        while(pointer!=null){
            myMap.put(cont,pointer);
            pointer=pointer.next;
            cont++;
        }
        if(myMap.get(cont-n-1)!=null){
            myMap.get(cont-n-1).next=myMap.get(cont-n).next;   
        }else{
            return head.next;
        }
        return head;
    }
}