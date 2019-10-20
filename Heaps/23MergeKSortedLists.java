        //Solution by leetcode's windliang
        //Priority queue approach, put first k elements in priority queue
        //And then start creating your list, grab the smaller element
        //and add the "next" of the smaller element to the priority queue, if there is next
        //Good runtime at 5ms better than 75.89% O(N log K) (Every push and pop takes log K,
        //while finding the smaller takes constant time)
        //Average memory less than 48.64% O(K) as the priority queue stores k items at most
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> cmp = new Comparator<ListNode>() {  
            @Override
            public int compare(ListNode o1, ListNode o2) {
                // TODO Auto-generated method stub
                return o1.val-o2.val;
            }
        };
 
        Queue<ListNode> q = new PriorityQueue<ListNode>(cmp);
        for(ListNode l : lists){
            if(l!=null){
                q.add(l);
            }        
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!q.isEmpty()){ 
            point.next = q.poll();
            point = point.next; 
            ListNode next = point.next;
            if(next!=null){
                q.add(next);
            }
            /*Memory tweak
            point = point.next; ;
            if(point.next!=null){
                q.add(point.next);
            }
            */
        }
        return head.next;
    }
}

        //My own priorityQueue approach from the second time I found this problem
        //CURIOSITY 
        //I used lambda comparison vs anonimous class above, all else is the same approach
        //using lambda resulted in a TERRIBLE runtime of 35ms, which can be seen as a spike in
        //the accepted runtime distribution, upon further research in internet it seems lamdba
        //could be a little slower, but not this bad, must be something to do with leetcode compiler
        //Average runtime of 35ms better than 41.94% O(N Log K), insertion/deletion takes Log K
        //and we do this for N elements
        //Better memory than 34% O(K)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result=new ListNode(0);
        
        //A comparator is an object, like a list it needs a type between <>
        //a name= and after = sign you put what you need to compare, this is a difference
        //with a typical object
        //I missed comparator type 
        Comparator<ListNode>  myComp=(ListNode l1,ListNode l2)->l1.val-l2.val;
        
        PriorityQueue<ListNode> myQueue=new PriorityQueue<ListNode>(myComp);
        
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                myQueue.add(lists[i]);    
            }
        }
        
        ListNode pointer=result;
        while(!myQueue.isEmpty()){
            ListNode smallest=myQueue.poll();
            if(smallest.next!=null){
                myQueue.add(smallest.next);    
            }
            pointer.next=smallest;
            pointer=pointer.next;
        }
        return result.next;
    }
}


        //One by one comparison approach by leetcode's windliang
        //For every item in the result you'll search for the smallest of the k current
        //spaces in the array, taking k time for every N item
        //Bad approach, not brute force but no good
        //Runtime of O(N*K)
        //Memory of O(N) (here we create a new node a, thus making N 'a' nodes)
        //It can be O(1) if we do it in place   
public ListNode mergeKLists(ListNode[] lists) {
    int min_index = 0;
    ListNode head = new ListNode(0);
    ListNode h = head;
    while (true) {
        boolean isBreak = true; 
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) { 
                if (lists[i].val < min) {
                    min_index = i;
                    min = lists[i].val;
                } 
                isBreak = false;
            }

        }
        if (isBreak) {
            break;
        }
        //O(1) 
        //h.next = lists[min_index];
        ListNode a = new ListNode(lists[min_index].val);
        h.next = a;
        h = h.next; 
        lists[min_index] = lists[min_index].next;
    }
    h.next = null;
    return head.next;
}

        //Brute force approach by leetcode's windliang
        //Merge lists in an ArrayList, sort it and then put them in a ListNode
        //Bad approach, just here to know it
        //Runtime O(N log N)
        //Memory O(N)
public ListNode mergeKLists(ListNode[] lists) {
    List<Integer> l = new ArrayList<Integer>();
   
    for (ListNode ln : lists) {
        while (ln != null) {
            l.add(ln.val);
            ln = ln.next;
        }
    }
   
    Collections.sort(l);
 
    ListNode head = new ListNode(0);
    ListNode h = head;
    for (int i : l) {
        ListNode t = new ListNode(i);
        h.next = t;
        h = h.next;
    }
    h.next = null;
    return head.next;
}