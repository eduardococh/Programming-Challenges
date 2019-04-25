class MinStack {
		//Solution by leetcode sometimescrazy

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}


public class MinStack {
		//Linked List solution by leetcode shubh3

    public class stackNode {
        int val;
        stackNode next;
        public stackNode(int val){
            this.val = val;
        }
    }
    
    stackNode top;
    stackNode min;
    
    /** initialize your data structure here. */
    public MinStack() {
        top = null;
    }

    public void push(int x) {
        if(top == null){
            top = new stackNode(x);
            min = new stackNode(x);
        }else{
            if(x<=min.val){
                stackNode temp = new stackNode(x);
                temp.next = min;
                min = temp;
            }
            stackNode nextNode = new stackNode(x);
            nextNode.next = top;
            top = nextNode;
        }
    }

    public void pop() {
        if(top.val == min.val){
            min = min.next;
        }
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return min.val;
    }
}