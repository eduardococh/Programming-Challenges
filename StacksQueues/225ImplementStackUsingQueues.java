		//My solution
		//Not bad runtime at 42ms better than 96.82% insertion takes o(n) all else o(1)
		//Not bad memory at 33.8mb better than	94.91% taking o(n) 
		//Thought it was not good enough but appears that there's no other way
		//Another option is to do the inverse and take o(n) in deletion o(1) in insertion, but i prefer mine
		//Finally best option is leetcodes using only 1 queue
class MyStack {
    
    Queue<Integer> myQueue;

    public MyStack() {
        myQueue=new LinkedList<Integer>();
    }
    
    public void push(int x) {
        if(myQueue.isEmpty()){
            myQueue.add(x);
        }else{
            Queue queue2=new LinkedList<Integer>();
            queue2.add(x);
            while(!myQueue.isEmpty()){
                queue2.add(myQueue.remove());
            }
            myQueue=queue2;
        }
    }
    
    public int pop() {
        return myQueue.remove();
    }
    
    public int top() {
        return myQueue.peek();
    }
    
    public boolean empty() {
        return myQueue.isEmpty();
    }
}


		//Leetcode's solution using only one stack, we insert and for every insertion
		//invert the list by removing elements and inserting them 1 by 1 putting our new element at front
private LinkedList<Integer> q1 = new LinkedList<>();

// Push element x onto stack.
public void push(int x) {
    q1.add(x);
    int sz = q1.size();
    while (sz > 1) {
        q1.add(q1.remove());
        sz--;
    }
}