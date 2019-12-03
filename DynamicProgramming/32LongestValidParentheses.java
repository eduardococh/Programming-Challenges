        //Average runtime of 5ms better than 54.35% 
        //Good memory of 37.3mb better than 96.08%
class Solution {
    public int longestValidParentheses(String s) {
        int res=0;
        boolean valids[]=new boolean[s.length()];
        Stack<Integer> stack=new Stack<Integer>();
        final int len=s.length();
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                if(!stack.isEmpty()){
                    valids[i]=true;
                    valids[stack.pop()]=true;
                }
            }
        }
        int local=0;
        for(boolean b:valids){
            if(b){
                local++;
            }else{
                if(local>0){
                    if(local>res) res=local;
                    local=0;
                }
            }
        }
        if(local>0 && local>res) res=local;
        return res;
    }

}