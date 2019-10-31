        //My solution using stack and going forward-backward
        //Bad runtime of 5ms better than only 17.65% O(N) since it will at most do 2 or three pases to the
        //array (I might be wrong in this)
        //Amazing memory better than 100% O(N) (Our stack can have at most N elements)
        //PEEK POP
        //ARRAYS.COPYOFRANGE
class Solution {
    public int trap(int[] height) {
        int len=height.length;
        int res=0;
        if(len<3) return 0;
        int currentTallest=height[0];
        Stack<Integer> myStack=new Stack<Integer>();
        for(int i=1;i<len;i++){
            if(height[i]>currentTallest){
                while(!myStack.isEmpty()){
                    res+=currentTallest-myStack.pop();
                }
                currentTallest=height[i];
            }else{
                myStack.push(height[i]);
            }
        }
        if(!myStack.isEmpty()){
            res+=trap2(Arrays.copyOfRange(height,len-myStack.size()-1,len));
        }
        return res;
    }
    
    public int trap2(int[] height) {
        int len=height.length;
        int res=0;
        if(len<2) return 0;
        int currentTallest=height[len-1];
        Stack<Integer> myStack=new Stack<Integer>();
        for(int i=len-2;i>=0;i--){
            if(height[i]>=currentTallest){
                while(!myStack.isEmpty()){
                    res+=currentTallest-myStack.pop();
                }
                currentTallest=height[i];
            }else{
                myStack.push(height[i]);
            }
        }
        if(!myStack.isEmpty()){
            res+=trap(Arrays.copyOfRange(height,0,myStack.size()+1));
        }
        return res;
    }
}

        //A GENIUS solution from leetcode's 0ms sample
        //Amazing runtime 0ms better than 100% O(N)
        //Bad memory better than only 5.48% O(1)
        //Get the smallest of height[end or start] and start scanning for smaller elements
        //until you find an element equal or bigger, once found start the process again
        //this is two ended so you advance from front to back
class Solution {
    public int trap(int[] height) {
        int result = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            if (height[start] <= height[end]) {
                int current = height[start];
                while (height[++start] < current) {
                    result += current - height[start];
                }
            } else {
                int current = height[end];
                while(height[--end] < current) {
                    result += current - height[end];
                }
            }
        }
        return result;
    }
}