        //My solution
        //Terrible runtime, insertion takes O(1) but pop and peek O(N)
        //That's in theory but in practice runtime 0ms better than 100% 
        //Bad memory better than only 20.83%
        //Simple improvement, invert order, when pushing take o(N)
        //so when popping and peeking takes o(1)
class MyQueue {
    
    Stack<Integer> pushS;
    Stack<Integer> popS;

    /** Initialize your data structure here. */
    public MyQueue() {
        pushS=new Stack<>();
        popS=new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        pushS.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!pushS.isEmpty()){
            popS.push(pushS.pop());
        }
        int res=popS.pop();
        while(!popS.isEmpty()){
            pushS.push(popS.pop());
        }
        return res;
    }
    
    /** Get the front element. */
    public int peek() {
        while(!pushS.isEmpty()){
            popS.push(pushS.pop());
        }
        int res=popS.peek();
        while(!popS.isEmpty()){
            pushS.push(popS.pop());
        }
        return res;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushS.isEmpty();
    }
}

        //Amortized approach by leetcode
        //Same runtime and memory as my solution
        //GENIUS APPROACH
        //You have two stacks, s1 and s2, s1 is always used to push, you always push
        //to s1, s2 is used to pop, you always pop from s2, the magic is that
        //if you pop and s2 is empty you transfer all s1 to s2 and there you have your order
        //the problem of more items coming to s2 and messing is does not exist, because'
        //the order FORCES you to empty s2 before adding more elements
        //FRONT VARIABLE is very important and not so obvious, it functions by keeping the
        //first element of s1, because there's a period when s1 has elements and s2 is empty
        //that you can not peek from s2, but there are elements in s1, that's what front is
        //used for
class MyQueue {
    
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    private int front;

    /** Initialize your data structure here. */
    public MyQueue() {
        front=-1;
    }
    
    // Push element x to the back of queue.
    public void push(int x) {
        if (s1.empty())
            front = x;
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();    
    }
    
    /** Get the front element. */
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
