class Solution {
    public int trap(int[] height) {
        int len=height.length;
        int res=0;
        if(len<3) return 0;
        //System.out.println("NEW TRAP "+height[0]);
        int currentTallest=height[0];
        Stack<Integer> myStack=new Stack<Integer>();
        for(int i=1;i<len;i++){
            //System.out.println("we in "+height[i]);
            if(height[i]>currentTallest){
                while(!myStack.isEmpty()){
                    //System.out.println(currentTallest+" pop "+height[i]+"  add "+(currentTallest-myStack.peek()));
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
        //System.out.println("NEW TRAP 2 "+height[0]);
        int currentTallest=height[len-1];
        Stack<Integer> myStack=new Stack<Integer>();
        for(int i=len-2;i>=0;i--){
            //System.out.println("we in "+height[i]);
            if(height[i]>=currentTallest){
                while(!myStack.isEmpty()){
                    //System.out.println(currentTallest+" pop "+height[i]+"  add "+(currentTallest-myStack.peek()));
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